//来自黑马 接口学习
package chapter04.heima.demo01Interface.demo01;

/* 接口常识：
 * 1、接口就是多个类的公共规范。
 * 2、接口是一种引用数据类型，最重要的就是其中的 抽象方法
 * 3、如何定义一个接口：
 *  public interface 接口名称 {
 *      //接口内容
 *  }
 * 4、注意：替换成关键字interface之后，编译生成的字节码文件仍是： .java --> .class
 * 5、包含方法：
 *    java 7 ：常量、抽象方法
 *    java 8 增加： 默认方法、静态方法
 *    java 9 增加： 私有方法
 *
 * 接口使用步骤：
 * 1、接口不能直接使用，必须有一个""实现类*来"实现"接口，格式：
 *      public class 实现类名称 implements 接口名称 {
 *          //...
 *      }
 * 2、接口的实现类必须覆盖重写(实现)接口中所有的抽象方法。
 *    实现：去掉abstract关键字，加上方法体大括号
 * 3、创建实现类的对象，进行使用。
 *
 * 注意事项：
 * 如果实现类并没有覆盖重写接口中的所有的抽象方法，那么这个实现类自己就必须是抽象类。
 */

//抽象方法运用
public class Demo01Interface {
    public static void main(String[] args) {
//        //错误写法！不能直接new接口对象使用
//        MyInterfaceAbstract inter = new MyInterfaceAbstract();

        //创建实现类的对象使用
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
        impl.methodAbs3();
        impl.methodAbs4();
    }
}

/* 接口知识总结：
 * Java 9+版本中，接口内容可以有：
 *
 * 1、成员变量，其实是常量，格式：
 * [public] [static] [final] 数据类型 常量名称 = 数据值;
 * 注意：
 *      常量必须进行赋值，而且一旦赋值不能改变
 *      常量名称完全大写，用下划线进行分隔
 *
 * 2、接口中最重要的就是抽象方法，格式：
 * [public] [abstract] 返回值类型 方法名称(参数列表);
 * 注意：
 *      实现类必须覆盖重写接口所有的抽象方法，除非实现类是抽象类。
 *
 * 3、从Java 8开始，接口允许定义默认方法，格式：
 * [public] default 返回值类型 方法名称(参数列表) {方法体}
 * 注意：
 *      默认方法也可以被覆盖重写
 *
 * 4、从Java 8开始，接口允许定义静态方法，格式：
 * [public] static 返回值类型 方法名称(参数列表) {方法体}
 * 注意：
 *      应该通过接口名称进行调用，不应该通过实现类对象调用接口静态方法。
 *
 * 5、从Java 9开始，接口允许定义私有方法，格式：
 * 普通私有方法：private 返回值类型 方法名称(参数列表) {方法体}
 * 静态私有方法：private static 返回值类型 方法名称(参数列表) {方法体}
 * 注意：
 *      private的方法只有接口自己才能调用，不能被实现类或别人使用。*/
