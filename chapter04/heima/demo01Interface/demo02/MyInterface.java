//继承父类并实现多个接口
package chapter04.heima.demo01Interface.demo02;

//一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法
public interface MyInterface {
    public default void method() {
        System.out.println("接口的默认方法");
    }
}
