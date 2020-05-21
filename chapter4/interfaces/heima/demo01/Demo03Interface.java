//接口 静态方法
package chapter4.interfaces.heima.demo01;

/* 注意事项：
 * 1、不能通过接口实现类的对象来调用接口中的静态方法。
 * 2、正确用法：通过接口名称，直接调用其中的静态方法，格式：
 *    接口名称.静态方法名(参数);       */

//接口静态方法的使用
public class Demo03Interface {
    public static void main(String[] args) {
//        //创建实现类对象
          //使用静态方法不需要创建对象
//        MyInterfaceStaticImpl impl = new MyInterfaceStaticImpl();

//        //错误写法！
//        impl.methodStatic();

        //直接通过接口名称调用静态方法
        MyInterfaceStatic.methodStatic();
    }
}
