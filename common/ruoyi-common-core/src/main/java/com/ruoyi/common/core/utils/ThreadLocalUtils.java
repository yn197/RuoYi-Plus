package com.ruoyi.common.core.utils;


/**
 * @author 16074
 */
public class ThreadLocalUtils  {
    private static final ThreadLocal<Object> SYS_USER_THREAD_LOCAL = new ThreadLocal<Object>();

    public static void add(Object o) {
        SYS_USER_THREAD_LOCAL.set(o);
    }

    public static void remove() {
        SYS_USER_THREAD_LOCAL.remove();
    }

    public static Object get() {
        return SYS_USER_THREAD_LOCAL.get();
    }


    class SysUser {
        private String userName;
        private Long userId;
    }
}
