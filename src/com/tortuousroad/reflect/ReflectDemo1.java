package com.tortuousroad.reflect;

/**
 * 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
 */
public class ReflectDemo1 {
    public static void main(String[] args) {

        /**
         * 第一种表示方式,类名.class
         * 实际在告诉我们任何一个类都有一个隐含的静态成员
         */
        Class c1 = Foo.class;

        /**
         * 第二种表示方式,对象名.getClass()
         * 已经知道该类对象，通过getClass方法
         */
        Foo foo1 = new Foo();
        Class c2 = foo1.getClass();

        /**
         * 不管是c1还是c2,都代表了Foo类的类类型
         * 一个类只可能是Class类的一个实例对象
         * 即 c1 == c2 is true
         */
        System.out.println(c1 == c2);

        /**
         * 第二种表示方式,Class.forName("类的包名+类名");
         */
        Class c3 = null;
        try {
            c3 = Class.forName("com.tortuousroad.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2 == c3); //c1,c2,c3都代表了Foo类的类类型

        /**
         * 得到了类类型后，可以使用 对象名.newInstance() 来创建该类的对象
         * 使用c3.newInstance()方法，需要Foo类有无参数的构造方法
         * 方法得到的是Object类型的对象，需要强制转换成Foo类型
         */
        Foo foo = null;
        try {
            foo = (Foo) c3.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Foo {
    void print() {
        System.out.println("foo");
    }
}