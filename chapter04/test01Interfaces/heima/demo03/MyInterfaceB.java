package chapter04.test01Interfaces.heima.demo03;

//接口B
public interface MyInterfaceB {
    public abstract void methodB();

    //存在一个与A中重名的抽象方法
    public abstract void methodCommon();

    //存在一个与A中重名的默认方法
    public default void methodDefault() {
        System.out.println("BBB");
    }
}
