package com.issc.dy.singleton;

/**
 * 使用双重检查进一步做了优化，可以避免整个方法被锁，
 * 只对需要锁的代码部分加锁，可以提高执行效率。
 */
public class Singleton4 {
    // 私有构造
    private Singleton4() {}
    private static Singleton4 single = null;
    // 双重检查
    public static Singleton4 getInstance() {
        if (single == null) {
            synchronized (Singleton4.class) {
                if (single == null) {
                    single = new Singleton4();
                }
            }
        }
        return single;
    }
}
