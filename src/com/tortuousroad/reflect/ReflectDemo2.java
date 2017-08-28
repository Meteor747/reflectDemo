package com.tortuousroad.reflect;

import com.tortuousroad.reflect.util.OfficeAble;

/**
 * 动态加载类
 * Class.forName(“类的全称”)不仅表示类的类类型，还代表动态加载类
 * 需知道，每个java程序的执行包括了两个步骤：编译和运行
 * 编译时刻加载类是静态加载类，运行时刻加载类是动态加载类
 * 下面，程序将模拟一个Office办公工具，Office中常用的Word、Excel等都是其子类
 */
public class ReflectDemo2 {
    public static void main(String[] args) {
        try {
            /**
             * 本来要这样写的,Class.forName(args[0])
             * 在执行了 javac Word.java javac ReflectDemo2.java后
             * java ReflectDemo2 Word
             * 如果要打开Excel 可以直接 java ReflectDemo2 Excle
             * 当然，这时没有Excle类，但这时已经过了编译阶段，到了运行阶段了。类似QQ的在线升级，无需重新编译，都是用的动态加载
             */
            Class c = Class.forName("com.tortuousroad.reflect.util.Word");
            OfficeAble officeAble = (OfficeAble) c.newInstance();
            officeAble.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
