//自定义注解
package chapter16.heimaPro.demo03Annotation;

/*
 * 自定义注解
 * 格式：public @interface 注解名称 {属性列表}
 * 本质：public interface 注解名称 extends java.lang.annotation.Annotation {}
 *
 * 在命令行中先运行javac MyAnno.java生成class文件，再运行javap MyAnno.class反编译
 * 得到本质：
 * public interface MyAnno extends java.lang.annotation.Annotation {}
 *
 * 属性：接口中可以定义的成员方法
 * 要求：
 * 1、属性的返回值类型有下列取值
 * 基本数据类型、String、枚举、注解、以上类型的数组
 * 2、定义了属性，在使用时需要给属性赋值
 *  2.1如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值
 *  2.2如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
 *  2.3数组赋值时，值使用{}包裹
 *
 * 元注解：用于描述注解的注解
 * @Target：描述注解能够作用的位置
 * @Retention：描述注解被保留的阶段
 * @Documented：描述注解是否被抽取到api文档中
 * @Inherited：描述注解是否被子类继承
 * */
public @interface MyAnno {
    //注解的属性
    int age();
    String name() default "Jack";
//    public abstract String show2();
//
//    Person per();
//    MyAnno2 anno2();
//
    String[] strs();
}
