//继承
package chapter03.heima.demo01Extends.demo01Define;

/*
 * 在继承的关系中，"子类就是一个父类"，就是说，子类可以被当作父类看待
 * 例如，父类是员工，子类是讲师，那么"讲师就是一个员工"，关系：is-a
 *
 * 定义父类的格式：(一个普通的类定义)
 * public class 父类名称 {
 *      //...
 * }
 *
 * 定义子类的格式：
 * public class 子类名称 extends 父类名称 {
 *      //...
 * }
 * */
public class Demo01Extends {
    public static void main(String[] args) {
        //创建了一个子类对象
        Teacher teacher = new Teacher();

        //调用父类方法
        //Teacher类当中如果什么都没写，也会继承来自父类的method方法
        teacher.method();

        //创建另一个子类，助教的对象
        Assistant assistant = new Assistant();
        assistant.method();
    }
}
