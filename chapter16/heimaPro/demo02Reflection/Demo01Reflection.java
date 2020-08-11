//反射
package chapter16.heimaPro.demo02Reflection;

/*
 * 反射————框架设计的灵魂
 * 框架：半成品软件，可以在框架的基础上进行软件开发，简化编码
 * 反射：将类的各个组成部分分装为其他对象，这就是反射机制
 *
 * 优点：
 * 1、可以在程序运行过程中，操作这些对象
 * 2、可以解耦，提高程序的可扩展性
 *
 * 获取Class对象的方式：
 * 1、Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 *    多用于配置文件，将类名定义在配置文件中，读取文件，加载类
 * 2、类名.class：通过类名的属性class获取
 *    多用于参数的传递
 * 3、对象.getClass()：getClass方法定义在Object对象中
 *    多用于对象的获取字节码的方式
 *
 * 注意：同一个字节码文件(*.class)在一次程序运行过程中，只会加载一次
 * 不论通过哪一种方式获取的Class对象都是同一个
 *
 * 结论：三种创建方式获得的Class对象是同一个
 * */
public class Demo01Reflection {
    /**
     * 获取Class对象的方式：
     * 1、Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     * 2、类名.class：通过类名的属性class获取
     * 3、对象.getClass()：getClass方法定义在Object对象中
     * */
    public static void main(String[] args) throws ClassNotFoundException {
        //1、Class.forName("全类名")
        //如果类名写错，会出现ClassNotFoundException异常
        Class cls1 = Class.forName("chapter16.heimaPro.demo02Reflection.Person");
        System.out.println(cls1);
        //2、类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3、对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //==比较三个对象
        System.out.println(cls1 == cls2);       //true
        System.out.println(cls1 == cls3);       //true
    }
}
