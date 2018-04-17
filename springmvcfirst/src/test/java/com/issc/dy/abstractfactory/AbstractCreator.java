package com.issc.dy.abstractfactory;

public abstract class AbstractCreator {
    //创建A产品家族
    public abstract AbstractProductA createProductA();
    //创建B产品家族
    public abstract AbstractProductB createProductB();
    //如果有N个产品族，这里就应该有N个创建方法
}
