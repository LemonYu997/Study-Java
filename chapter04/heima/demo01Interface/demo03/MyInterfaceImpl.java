package chapter04.heima.demo01Interface.demo03;

//由于这个接口继承了A和B，所以在这里只需实现这一个接口
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void method() {

    }

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    //多个父接口中的抽象方法如果重复，没关系。
    @Override
    public void methodCommon() {

    }
}
