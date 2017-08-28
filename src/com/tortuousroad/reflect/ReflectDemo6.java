package com.tortuousroad.reflect;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射了解集合泛型的本质
 */
public class ReflectDemo6 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<>();

        list1.add("hello");
        //list1.add(234); //编译出错，add (java.lang.String) in ArrayList cannot be applied to (int)
        Class c = list.getClass();
        Class c1 = list1.getClass();

        System.out.println(c.getName()); // java.util.ArrayList
        System.out.println(c1.getName());
        System.out.println(c==c1); //true


        /**
         * c==c1 结果返回true，说明编译之后集合的泛型是去泛型话的
         * Java中集合的泛型，是防止错误输入的，只在编译阶段有效
         * 绕过了编译就无效了
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */
        try {
            Method m = c1.getDeclaredMethod("add",Object.class);
            m.invoke(list1,30); //这里没有报错，绕过了编译，也就绕过了泛型。
            System.out.println(list1.size());
            System.out.println(list1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /**
         * 输出结果：
         *  java.util.ArrayList
            java.util.ArrayList
            true
            2
            [hello, 30]
         */
    }
}
