package com.issc.dy.singleton;

/**
 * 饿汉式单例模式：在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。
 * 类加载初始化时就创建好一个静态的对象供外部使用，除非系统重启，
 * 这个对象不会改变，所以本身就是线程安全的。
 */

// 饿汉式单例
public class Singleton1 {
    // 私有构造
    private Singleton1() {}
    private static Singleton1 single = new Singleton1();
    public static Singleton1 getInstance() {
        return single;
    }
}
