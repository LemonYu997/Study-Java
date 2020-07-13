//使用类
package chapter02.heima.demo01Object;

/*
 * 通常情况下，一个类不能直接使用，需要根据类创建一个对象，才能使用
 *
 * 1、导包：指出需要使用的类在什么位置
 * import 包名称.类名称;
 * import chapter2.heima.demo01Object.Student;
 * 对于和当前类属于同一个包的情况，可以省略导包语句不写
 *
 * 2、创建
 * 类名称 对象名 = new 类名称();
 * student stu = new Student();
 *
 * 3、使用，分两种情况
 * 使用成员变量：对象名.成员变量名
 * 使用成员方法：对象名.成员方法名(参数)
 *（想用谁，就点儿谁）
 *
 * 注意事项：
 * 如果成员变量未赋值，将会有一个默认值，规则和数组一样
 */


public class Demo02Student {
    public static void main(String[] args) {
        //1、导包
        //Student类和自己位于同一个包下，省略不写

        //2、创建，格式：
        //类名称 对象名 = new 类名称();
        Student stu = new Student();

        //3、使用，格式：
        //对象名.成员变量
        System.out.println(stu.name);       //null
        System.out.println(stu.age);        //0
        System.out.println("-----------------");

        //改变对象当中的成员变量数值内容
        //将右侧的字符串，赋值交给stu对象当中的name成员变量
        stu.name = "Joker";
        stu.age = 18;
        System.out.println(stu.name);       //Joker
        System.out.println(stu.age);        //18
        System.out.println("-----------------");

        //4、使用对象的成员方法，格式：
        //对象名.成员方法名()
        stu.eat();
        stu.sleep();
        stu.study();
    }
}
