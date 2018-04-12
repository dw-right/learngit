package com.issc.dy.singleton;

/**
 *  在方法上加synchronized同步锁或是用同步代码块对类加同步锁，此种方式虽然解决了多
 *  个实例对象问题，但是该方式运行效率却很低下，下一个线程想要获取对象，
 *  就必须等待上一个线程释放锁之后，才可以继续运行。
 */
public class Singleton3 {
    // 私有构造
    private Singleton3() {}

    private static Singleton3 single = null;

    public static Singleton3 getInstance() {

        // 等同于 synchronized public static Singleton3 getInstance()
        synchronized(Singleton3.class){
            // 注意：里面的判断是一定要加的，否则出现线程安全问题
            if(single == null){
                single = new Singleton3();
            }
        }
        return single;
    }
}
