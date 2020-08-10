//通过super引用父类的成员方法
package chapter15.heimaPro.demo03MethodReference;

//定义见面的函数式接口
@FunctionalInterface
public interface Greetable {
    //定义一个见面的方法
    void greet();
}
