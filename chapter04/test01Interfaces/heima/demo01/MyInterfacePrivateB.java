//接口私有方法 用于java 9
package chapter04.test01Interfaces.heima.demo01;

//静态方法的私有
public interface MyInterfacePrivateB {
    //静态方法1
    public static void methodStatic1() {
        System.out.println("静态方法1");
        methodCommon1();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
    }

    //默认方法2
    public static void methodStatic2() {
        System.out.println("静态方法2");
        methodCommon1();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
    }

    //新增的共有方法，不太合适，都可以调用
    public static void methodCommon1() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

    //由于这里使用的是java 8，所以会报错，就先注释掉了
//    private static void methodCommon2() {
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
}
