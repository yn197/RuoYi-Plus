package com.ruoyi.web.stream;


import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.utils.ThreadLocalUtils;

public class ThreadLocalTest {

    public static void main(String[] args) {
        Object o = ThreadLocalUtils.get();
        System.out.println(o);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("张三");
        sysUser.setUserId(1L);
        ThreadLocalUtils.add(sysUser);
        Object user1 = ThreadLocalUtils.get();
        System.out.println(user1);
        ThreadLocalUtils.remove();
        Object user2 = ThreadLocalUtils.get();
        System.out.println(user2);
        System.out.println(ThreadLocalUtils.get());
    }
}
