package com.gu01e.aicodegenerator.context;

/**
 * @author GUOLE
 * @version v1.0
 * @description 当前线程中保存的当前用户id
 * @date 2025/10/14 22:07
 */
public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}