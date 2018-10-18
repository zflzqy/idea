package com.ssm.twoday;

import java.lang.reflect.Field;

public class Reflect {
    public static  void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 反射
        Class test = Test.class;
        // 通过反射创建一个新的对象
        Test t = (Test) test.newInstance();
        t.print(13,11);
        // 通过反射操作成员变量
        // 1.通过反射拿到指定的成员变量,getFiele(String name)只能获取public
        Field field = test.getDeclaredField("name");
        // 2.成员变量对象操作
        // 2.1当成员变量私有时，设定能够访问，设定能够访问私有的成员变量或方法
        field.setAccessible(true);
        // 2.2给成员变量赋值,操作哪个对象，操作的值是多少
        field.set(t,"赵飞龙");
        System.out.println(t.getName());
        // @SuppressWarnings()压制警告
    }
}
