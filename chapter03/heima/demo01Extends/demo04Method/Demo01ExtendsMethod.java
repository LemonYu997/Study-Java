//继承中成员方法的访问特点
package chapter03.heima.demo01Extends.demo04Method;

/*
 * 在父类的继承关系当中，创建子类对象，访问成员方法的规则：
 * 创建的对象是谁，就优先用谁，如果没有则向上找
 *
 * 注意事项：
 * 无论是成员方法还是成员变量，如果没有都是向上找父类，绝对不会向下找子类的
 * */
public class Demo01ExtendsMethod {
    public static void main(String[] args) {
        Zi zi = new Zi();

        zi.methodFu();
        zi.methodZi();
        System.out.println("------------------");

        //创建的是子类对象，优先用子类方法
        zi.method();
    }
}
