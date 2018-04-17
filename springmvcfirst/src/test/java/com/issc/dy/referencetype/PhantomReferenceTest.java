package com.issc.dy.referencetype;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args) {
        String str1=new String("虚引用");
        //创建一个引用队列
        ReferenceQueue<String> rq=new ReferenceQueue();
        //创建虚引用，让虚引用引用到“虚引用”
        PhantomReference<String> pr=new PhantomReference(str1,rq);
        str1=null;
        //取出虚引用所引用的对象
        //程序不能通过虚引用访问被引用的对象
        System.out.println(pr.get());
        System.gc();
        System.gc();
        //System.runFinalization();
        //取出引用队列中最先进入队列引用与pr对比
        System.out.println(rq.poll()==pr);
    }
}
