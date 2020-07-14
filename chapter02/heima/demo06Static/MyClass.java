package chapter02.heima.demo06Static;

public class MyClass {

    int num;    //成员变量
    static int numStatic;   //静态变量

    //成员方法
    public void method() {
        System.out.println("这是一个普通的成员方法。");
        //成员方法可以访问成员变量
        System.out.println(num);
        //成员方法可以访问静态变量
        System.out.println(numStatic);
    }

    //静态方法
    public static void methodStatic() {
        System.out.println("这是一个静态方法。");
        //静态方法可以访问静态变量
        System.out.println(numStatic);
//        //错误！静态方法不能访问成员变量
//        System.out.println(num);

//        //错误！静态方法当中不能使用this关键字
//        System.out.println(this);
    }
}
