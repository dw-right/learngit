package com.issc.dy.factorymethod;

public class FactoryBMW750 implements FactoryBMW{

    @Override
    public BMW750 createBMW() {

        return new BMW750();
    }

}
