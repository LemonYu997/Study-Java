//注解
package chapter16.heimaPro.demo03Annotation;

/*
 * 注解：说明程序，给计算机看
 * 注释：用文字描述，给程序员看
 *
 * 定义：注解(Annotation)，也叫元数据。是一种代码级别的说明，JDK1.5+引入的特性，与类、接口、枚举在同一个层次。
 * 可以声明在包、类、字段、方法、局部变量、方法参数等面前，用来对这些元素进行说明和注释
 *
 * 作用分类：
 * 1、编写文档：通过代码里的标识的元数据生成文档【生成doc文档】
 * 2、代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
 * 3、编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查【Override】
 *
 * 使用注解：@注解名称
 *
 * 学习内容：
 * JDK种预定义的一些注解
 * 自定义注解
 * 在程序中使用(解析)注解
 *
 *
 * 小结：
 * 1、大多数时候，使用注解而不是自定义注解
 * 2、注解给谁用？
 *    a.编译器
 *    b.解析程序
 * 3、注解不是程序的一部分
 * */

/**
 * 注解javadoc演示
 *
 * @author mly
 * @version 1.0
 * @since 1.5
 * */
public class Demo01Annotation {
    /**
     * 计算两数的和
     * @param a 整数
     * @param b 整数
     * @return 两数的和
     * */
    public int add (int a, int b) {
        return a + b;
    }
}
