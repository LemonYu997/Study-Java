//方法引用
package chapter15.heimaPro.demo03MethodReference;

/*
 * 定义一个打印的函数式接口
 * */
@FunctionalInterface
public interface Printable {
    //打印字符串的抽象方法
    void print(String s);
}
