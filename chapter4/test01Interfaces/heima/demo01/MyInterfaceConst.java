//接口常量定义和使用
package chapter4.test01Interfaces.heima.demo01;

/* 重点：
 * 接口当中也可以定义“成员变量”，但是必须使用public static final 三个关键字进行修饰
 * 从效果上看，这其实就是接口的【常量】
 * 格式：
 * public static final 数据类型 常量名称 = 数据值;
 *
 * 注意：
 * 1、一旦使用final关键字进行修饰，说明不可改变。
 * 2、接口当中的常量，可以省略public static final，不写也仍是常量。
 * 3、接口中的常量必须进行赋值，不能不赋值。
 * 4、接口中常量的名称，使用完全大写的字母，用下划线进行分隔*/
public interface MyInterfaceConst {
    //这其实就是一个常量，一旦赋值，不可以修改
    //不能变的量一般用完全大写字母，多个单词用下划线隔开
    public static final int NUM_OF_IT = 10;
}
