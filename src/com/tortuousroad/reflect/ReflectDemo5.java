package com.tortuousroad.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法反射
 * 如何获取某个方法？方法的名称和方法的参数列表才能唯一决定某个方法
 * 方法反射的操作。method.invoke(对象，参数列表)
 */
public class ReflectDemo5 {

    public static void main(String[] args) {
        /**
         * 要获取A类的print(int,int)方法
         * 要获取一个方法就是要获取类的信息，获取类的信息首先要获取类的类类型
         */
        A a = new A();
        Class class1 = a.getClass();

        /**
         * 获取方法 名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDeclaredMethod获取的是自己声明的方法
         */
        try {
            //获取到print(int,int)方法
            Method method1 = class1.getMethod("print",int.class,int.class);
            /**
             * 方法的反射操作
             * a.print(10,20);
             * 方法的反射操作是用method1对象来进行方法调用 和a.print调用效果是一样的
             * 如果方法有具体的返回值，o就得到返回类型，方法如果没有返回值，返回null
             */
            Object o = method1.invoke(a,10,20);

            System.out.println("--------------------------------");

            //获取print(String,String)方法
            Method method2 = class1.getMethod("print",new Class[]{String.class,String.class});
            o = method2.invoke(a,new Object[]{"hello","baby"});

            System.out.println("--------------------------------");

            //Method method3 = class1.getMethod("print",new Class[]{});
            Method method3 = class1.getMethod("print");
            method3.invoke(a,new Object[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
class A {

    public void print() {
        System.out.println("helloworld".toUpperCase());
    }

    public void print(int a,int b) {
        System.out.println(a+b);
    }

    public void print(String a,String b) {
        System.out.println(a.toUpperCase()+"," + b.toLowerCase());
    }
}