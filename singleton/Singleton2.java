package com.issc.dy.singleton;

/**
 * 懒汉式单例模式：在类加载时不初始化。
 * 延迟加载方式实现了懒汉式单例.
 * 多线程环境下会产生多个single对象,线程不安全
 *
 */
// 懒汉式单例
public class Singleton2 {
    // 私有构造
    private Singleton2() {}
    private static Singleton2 single = null;
    public static Singleton2 getInstance() {
        if(single == null){
            single = new Singleton2();
        }
        return single;
    }
}