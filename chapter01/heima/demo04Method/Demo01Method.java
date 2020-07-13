//黑马 方法
package chapter01.heima.demo04Method;

/*
 * 定义一个方法的格式：
 * public static void 方法名称() {
 *      方法体
 * }
 *
 * 方法名称的命名规则和变量一样，使用小驼峰。
 * 方法体：大括号当中可以包含任意条语句
 *
 * 注意事项：
 * 1、方法定义的先后顺序无所谓
 * 2、方法的定义不能产生嵌套包含关系
 * 3、方法定义好后不会执行，想执行时必须进行【调用】
 *
 * 如何调用方法，格式：
 * 方法名称();
 *
 * */

public class Demo01Method {
    public static void main(String[] args) {
        farmer();
        seller();
        cook();
        me();
    }


    //农民伯伯
    public static void farmer() {
        System.out.println("播种");
        System.out.println("浇水");
        System.out.println("施肥");
        System.out.println("除虫");
        System.out.println("收割");
        System.out.println("卖给小商贩");
    }

    //小商贩
    public static void seller() {
        System.out.println("运输");
        System.out.println("提价");
        System.out.println("吆喝");
        System.out.println("卖给厨子");
    }

    //厨子
    public static void cook() {
        System.out.println("洗菜");
        System.out.println("切菜");
        System.out.println("炒菜");
        System.out.println("装盘");
    }

    //我
    public static void me() {
        System.out.println("吃");
    }
}
