package com.issc.dy.simplefactory;

class Factory{
    public static void show(String type){//传入参数，根据不同的类型个性化定制
        if(type.equals("")){//为空的情况，不用往下执行
            System.out.println("对不起，类型为空！,请重新输入！");
            return;
        }
        Car c = null;
        if("BMW".equals(type)){//判断类型
            c = new BMW();
        }else{
            c = new BYD();
        }
        c.drive();
    }
}
