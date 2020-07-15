//继承中成员变量的访问特点
package chapter03.heima.demo01Extends.demo02Field;

/*
 * 在父子类的继承关系当中，如果成员变量重名，则创建子类对象时，访问有两种方式：
 *
 * 直接通过子类对象访问成员变量：
 *      等号左边是谁，就优先用谁，没有则向上找
 *
 * 间接通过成员方法访问成员变量：
 *      方法属于谁，就有先用谁，没有则向上找
 *
 * */

public class demo01ExtendsField {
    public static void main(String[] args) {
        Fu fu = new Fu();               //创建父类对象
        System.out.println(fu.numFu);   //10  只能使用父类的东西，没有任何子类内容

        Zi zi = new Zi();
        System.out.println(zi.numFu);   //10，子类中没有，向上找
        System.out.println(zi.numZi);   //20
        System.out.println("-----------------");

        //重名变量
        System.out.println(zi.num);     //200 子类调用，优先用子类
//        System.out.println(zi.abc);     //无此变量，报错
        System.out.println("-----------------");

        //这个方法是子类的，优先用子类，没有则向上找
        zi.methodZi();                  //200
        //这个方法是在父类中定义的，优先用父类中的num
        zi.methodFu();                  //100
    }
}
