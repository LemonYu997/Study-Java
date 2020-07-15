//接口学习 定义抽象方法
package chapter04.heima.demo01Interface.demo01;

//接口的实现类必须要覆盖重写所有抽象方法，少一个就会报错
public class MyInterfaceAbstractImpl implements MyInterfaceAbstract {

    @Override
    public void methodAbs1() {
        System.out.println("First method.");
    }

    @Override
    public void methodAbs2() {
        System.out.println("Second method.");
    }

    @Override
    public void methodAbs3() {
        System.out.println("Third method.");
    }

    @Override
    public void methodAbs4() {
        System.out.println("Fourth method.");
    }
}
