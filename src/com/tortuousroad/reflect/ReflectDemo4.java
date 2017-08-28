package com.tortuousroad.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 获取成员变量与构造函数信息
 */
public class ReflectDemo4 {

    /**
     * 通过反射获取类中变量信息
     * 成员变量也是对象
     * 是Java.lang.reflect.Field类的对象
     * Field封装了关于成员变量的操作
     * getFields()方法获取的是所有的public的成员变量的信息
     * getDeclaredFields获取的是该类自己声明的成员变量的信息
     *
     */
    public static void printFiledMessage(Object object) {
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            //得到成员变量的类型的类类型
            Class type = field.getType();
            //得到了成员变量的名称
            String name = field.getName();
            System.out.println(type.getName() + " " + name);
        }
    }

    /**
     * 构造函数同样也是对象
     * java.lang.Constructor中封装了构造函数的信息
     *
     */
    public static void printConMessage(Object object) {
        Class c = object.getClass();
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print(name + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class param : parameterTypes) {
                System.out.print(param.getName() + ",");// 参数类型的名称
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        Integer i = new Integer(2);
        printFiledMessage(i);
        System.out.println("----------------------------------");
        printConMessage(i);
    }
}
