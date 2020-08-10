//通过this引用本类的成员方法
package chapter15.heimaPro.demo03MethodReference;

/*
 * 定义一个富有的函数式接口
 * */
@FunctionalInterface
public interface Richable {
    //定义一个想买什么就买什么的方法
    void buy();
}
