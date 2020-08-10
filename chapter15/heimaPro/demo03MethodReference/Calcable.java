//通过类名引用静态成员方法
package chapter15.heimaPro.demo03MethodReference;

@FunctionalInterface
public interface Calcable {
    //定义一个抽象方法，传递一个整数，对整数进行绝对值计算并返回
    int calsAbs(int number);
}
