package com.issc.dy.singleton;

/**
 * 静态内部类虽然保证了单例在多线程并发下的线程安全性，
 * 但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的
 */
public class Singleton5 {
    // 私有构造
    private Singleton5() {}

    // 静态内部类
    private static class InnerObject{
        private static Singleton5 single = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return InnerObject.single;
    }
}
