package com.ruoyi.reflect.spring.springframework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.Introspector;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nisang
 * 2023/10/6 10:53
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class ApplicationContext {
    private Class configClass;
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String, Object> singletonObjects = new HashMap<>();
    /**
     * 存放扫描包路径下的所有BeanPostProcessor类
     */
    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public ApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 扫描
        scan(configClass);

        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton") && !beanDefinition.isLazy()) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        Class clazz = beanDefinition.getType();

        try {
            Object o = clazz.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(o, bean);
                }
            }

            if (o instanceof BeanNameAware) {
                ((BeanNameAware) o).setBeanName(beanName);
            }

            if (o instanceof ApplicationContextAware) {
                ((ApplicationContextAware) o).setApplicationContext(this);
            }

            // 遍历后置处理器列表，执行后置处理器的before方法，在Bean 的初始化方法（如 @PostConstruct 注解的方法）被调用之前被自动调用
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                o = beanPostProcessor.postProcessBeforeInitialization(beanName, o);
            }

            if (clazz.isAnnotationPresent(Transactional.class)) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(clazz);
                Object target = o;
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("开启事务");
                        Object result = method.invoke(target, objects);
                        System.out.println("提交事务");
                        return result;
                    }
                });
                o = enhancer.create();
            }
            // 初始化
            if (o instanceof InitializingBean) {
                ((InitializingBean) o).afterPropertiesSet();
            }

            //Bean后置处理器接口的after方法，在 Bean 的初始化方法被调用之后被自动调用
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                o = beanPostProcessor.postProcessAfterInitialization(beanName, o);
            }
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void scan(Class configClass) {
        // 获取要扫描的包路径
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan annotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = annotation.value();

            path = path.replace(".", "/");

            ClassLoader classLoader = this.getClass().getClassLoader();
            URL resource = classLoader.getResource("com/ruoyi/reflect/spring/user");
            String decode = null;
            try {
                decode = URLDecoder.decode(resource.getPath(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            File file = new File(decode);

            List<File> classFile = new ArrayList<>();
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    if (f.isDirectory()) {
                        for (File f1 : f.listFiles()) {
                            if (!f1.isDirectory()) {
                                classFile.add(f1);
                            }
                        }
                    } else {
                        classFile.add(f);
                    }

                }
            }

            for (File cFile : classFile) {
                String absolutePath = cFile.getAbsolutePath();
                String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"))
                        .replace("\\", ".");

                try {
                    Class<?> clazz = classLoader.loadClass(className);

                    if (clazz.isAnnotationPresent(Component.class)) {
                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setType(clazz);
                        beanDefinition.setLazy(clazz.isAnnotationPresent(Lazy.class));
                        //判断这个Bean类是不是BeanPostProcessor接口的实现类，如果是的话就通过反射创建实例，并放进处理器列表里。
                        //注意不能用instanceof，因为instanceof是实例与类的关系比较，isAssignableFrom是类和接口的关系比较
                        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                            BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                            beanPostProcessorList.add(instance);
                            System.out.println("这个Bean是BeanPostProcessor接口的实现类，需要加入list里，以供所有Bean初始化之前和之后增强");
                        }

                        if (clazz.isAnnotationPresent(Scope.class)) {
                            beanDefinition.setScope(clazz.getAnnotation(Scope.class).value());
                        } else {
                            beanDefinition.setScope("singleton");
                        }

                        String beanName = clazz.getAnnotation(Component.class).value();
                        if (beanName.isEmpty()) {
                            beanName = Introspector.decapitalize(clazz.getSimpleName());
                        }

                        beanDefinitionMap.put(beanName, beanDefinition);

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {
            throw new NullPointerException();
        }

        if ("singleton".equals(beanDefinition.getScope())) {
            Object result = singletonObjects.get(beanName);
            if (result == null) {
                result = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, result);
            }
            return result;
        } else {
            return createBean(beanName, beanDefinition);
        }
    }
}
