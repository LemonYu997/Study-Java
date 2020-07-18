//泛型受限
package chapter06.heimaPro.demo01Generic;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 通配符高级使用——受限泛型
 * 设置泛型的时候，可以指定泛型的上限和下限
 *
 * 泛型的上限：
 *      格式：类型名称 <? extends 类> 对象名称
 *      意义：只能接收该类型本身及其子类
 * 泛型的下限：
 *      格式：类型名称 <? super 类> 对象名称
 *      意义：只能接收该类型本身及其父类型
 * */
public class Demo06Limit {
    public static void main(String[] args) {

        /*
         * 类与类之间的继承关系
         * Integer extends Number extends Object
         * String extends Object
         * */
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement1(list1);
//        getElement1(list2);     //报错 String类不是Number及其子类
        getElement1(list3);
//        getElement1(list4);     //报错 Object类不是Number及其子类

//        getElement2(list1);     //报错 Integer类不是Number及其父类
//        getElement2(list2);     //报错 String类不是Number及其父类
        getElement2(list3);
        getElement2(list4);
    }

    //泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll) {}

    //泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll) {}
}
