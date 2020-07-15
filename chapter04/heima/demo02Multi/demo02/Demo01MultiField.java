//多态中成员变量的使用方法
package chapter04.heima.demo02Multi.demo02;

/*
 * 访问成员变量的两种方式：
 *
 * 1、直接通过对象名称访问成员变量：看等号左边，优先用谁，没有则向上找
 * 2、简接通过成员方法访问：该方法属于谁，优先用谁，没有则向上找
 * */
public class Demo01MultiField {
    public static void main(String[] args) {
        //使用多态的写法，父类引用指向子类对象
        Fu obj = new Zi();
        System.out.println(obj.num);        //10 访问父类成员变量
//        System.out.println(obj.age);      //错误写法，age在子类中
        System.out.println("------------------");

        //若子类没有覆盖重写，就是父 10
        //若子类覆盖重写，就是子 20
        obj.showNum();                      //20 子类覆盖重写
    }
}
