package com.issc.dy.referencetype;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    public String toString(){
        return "name="+name+",age="+age;
    }
}
public class SoftReferenceTest {
    public static void main(String[] args) {
        //String str=new String("弱引用");
        //创建软引用数组
        SoftReference<Person>[] people=new SoftReference[16];
        for(int i=0;i<people.length;i++){
            people[i]=new SoftReference<Person>(new Person("name"+i,i));
        }
        System.out.println(people[3].get());
        System.out.println(people[4].get());
        //垃圾回收机制
        System.gc();
        System.gc();
        System.out.println(people[3].get());
        System.out.println(people[4].get());
        /*WeakReference<String> wr=new WeakReference(str);
        str=null;
        System.out.println(wr.get());
        System.gc();
        System.out.println(wr.get());*/

    }
}
