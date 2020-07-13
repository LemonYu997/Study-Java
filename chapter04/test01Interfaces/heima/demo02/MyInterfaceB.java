//继承父类并实现多个接口
package chapter04.test01Interfaces.heima.demo02;

public interface MyInterfaceB {

    public abstract void methodB();

    //与A中重名方法
    public abstract void methodAbs();

    public default void methodDefault() {
        System.out.println("默认方法BBB");
    }
}
