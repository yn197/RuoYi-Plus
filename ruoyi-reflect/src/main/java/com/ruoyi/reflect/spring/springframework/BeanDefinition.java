package com.ruoyi.reflect.spring.springframework;

/**
 * @author nisang
 * 2023/10/6 10:55
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class BeanDefinition {
    private Class type;
    private String scope;
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
