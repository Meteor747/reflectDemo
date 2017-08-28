package com.tortuousroad.reflect;

import java.lang.reflect.Method;

/**
 * 打印输出类中每个方法的信息（返回值类型 方法名 方法参数类型）
 */
public class ReflectDemo3 {

    public static void publicClassMessage(Object object) {

        /**
         * 要获取类的信息，首先要获取类的类类型
         * 传递的是哪个子类的对象，c就是该子类的类类型
         */
        Class c = object.getClass();

        System.out.println(c.getName()); //输出当前类的名称

        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()获取的是所有public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法不问访问权限
         */
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            /**
             * 得到方法返回值类型的类类型
             * 如果方法返回值是String，那么得到的就是String.class
             */
            Class classType = method.getReturnType();
            System.out.print(classType.getSimpleName()+" "); //输出返回值类型的名称

            System.out.print(method.getName()+"("); //输出方法名

            /**
             * 获取参数类型
             * 得到的是参数列表的类型的类类型
             */
            Class[] paramTypes = method.getParameterTypes();
            int total = paramTypes.length;
            int count = 0;
            for (Class param : paramTypes) {
                count++;
                if (total>count) {
                    System.out.print(param.getSimpleName() + ",");
                }
                else {
                    System.out.print(param.getSimpleName());
                }
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        Integer i = new Integer(3);
        ReflectDemo3.publicClassMessage(i);
    }
}
