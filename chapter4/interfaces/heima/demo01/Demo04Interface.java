//接口私有方法 Java 9才可用
package chapter4.interfaces.heima.demo01;

//方法使用
public class Demo04Interface {
    public static void main(String[] args) {
        MyInterfacePrivateB.methodStatic1();
        MyInterfacePrivateB.methodStatic2();

        //如果methodCommon2()是私有方法，这里无法调用
//        MyInterfacePrivateB.methodCommon2();
    }
}
