//接口之间的多继承
package chapter4.interfaces.heima.demo03;

/* 接口之间的关系：
 * 1、类与类之间是单继承的，直接父类只能有一个。
 * 2、类与接口直接是多实现的，一个类可以实现多接口。
 * 3、接口与接口之间是多继承的。
 *
 * 注意事项：
 * 1、多个父接口中的抽象方法如果重复，没关系。
 * 2、多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写。
 *    而且要带着【default】关键字！！
 * */

public class Demo01Relations {
}