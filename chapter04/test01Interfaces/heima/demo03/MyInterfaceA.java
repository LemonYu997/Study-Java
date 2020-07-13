package chapter04.test01Interfaces.heima.demo03;

//接口A
public interface MyInterfaceA {
    public abstract void methodA();

    public abstract void methodCommon();

    public default void methodDefault() {
        System.out.println("AAA");
    }
}
