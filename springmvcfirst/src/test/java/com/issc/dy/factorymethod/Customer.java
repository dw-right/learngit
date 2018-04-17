package com.issc.dy.factorymethod;

public class Customer {
    public static void main(String[] args) {
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        BMW320 bmw320 = factoryBMW320.createBMW();

        FactoryBMW750 factoryBMW750 = new FactoryBMW750();
        BMW750 bmw750 = factoryBMW750.createBMW();
    }
}
