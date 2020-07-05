//接口私有方法 用于java 9
package chapter4.test01Interfaces.heima.demo01;

/* 问题描述：
 * 需要抽取一个公共方法，用来解决两个默认方法之间重复代码的问题，
 * 但是这个共有方法不应该让实现类使用，应该是私有化的。
 *
 * 解决方法：
 * 从Java 9开始，接口中允许定义私有方法。
 * 1、普通私有方法，解决多个默认方法之间重复代码问题
 *    格式：
 *    private 返回值类型 方法名称(参数列表) {
 *          //方法体
 *    }
 *
 * 2、静态私有方法，解决多个静态方法之间重复代码问题
 *    格式：
 *    private static 返回值类型 方法名称(参数列表) {
 *          //方法体
 *    }
 * */

//默认方法的私有
public interface MyInterfacePrivateA {

    //默认方法1
    public default void methodDefault1() {
        System.out.println("默认方法1");
        methodCommon1();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
    }

    //默认方法2
    public default void methodDefault2() {
        System.out.println("默认方法2");
        methodCommon1();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
    }

    //新增的共有方法，不太合适，因为实现类中可以直接调用
    public default void methodCommon1() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

    //由于这里使用的是java 8，所以会报错，就先注释掉了
//    private void methodCommon2() {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
}
