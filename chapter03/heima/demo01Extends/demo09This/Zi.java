//this关键字
package chapter03.heima.demo01Extends.demo09This;

/*
 * super关键字用来访问父类内容，而this关键字用来访问本类内容，用法有三种：
 * 1、在本类的成员方法中，访问本类的成员变量
 * 2、在本类的成员方法中，访问本类的另一个成员方法
 * 3、在本类的构造方法中，访问本类的另一个构造方法
 *    注意：
 *    A、this(...)调用也必须是构造方法的第一个语句，唯一一个
 *    B、super和this两种构造调用，不能同时使用
 * */
public class Zi extends Fu {

    int num = 20;

    //无参构造
    public Zi() {
//        super();      //这一行不再赠送
        //本类的无参构造，调用本类的有参构造
        this(123);
//        this(1,2);  //错误，只能有一个this
    }

    //有参构造
    public Zi (int n) {
        this(1, 2);
    }

    public Zi(int n, int m) {
//        this();   //错误写法，循环调用
    }

    public void showNum() {
        int num = 10;
        System.out.println(num);        //局部变量
        System.out.println(this.num);   //本类中的成员变量
        System.out.println(super.num);  //父类中的成员变量
    }

    public void methodA() {
        System.out.println("AAA");
    }

    public void methodB() {
        this.methodA();                 //访问本类当中的另一个方法
        System.out.println("BBB");
    }
}
