//super关键字
package chapter03.heima.demo01Extends.demo08Super;

/*
 * super关键字的用法有三种：
 * 1、在子类的成员方法中，访问父类的成员变量
 * 2、在子类的成员方法中，访问父类的成员方法
 * 3、在子类的构造方法中，访问父类的构造方法
 * */

public class Zi extends Fu {
    int num = 20;

    public Zi() {
        //默认调用super();
    }

    public void methodZi() {
        System.out.println(super.num);  //10 父类的num
    }

    public void method() {
        super.method();     //访问父类的method
        System.out.println("子类成员方法");
    }
}
