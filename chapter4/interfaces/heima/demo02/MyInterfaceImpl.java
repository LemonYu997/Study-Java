//继承父类并实现多个接口
package chapter4.interfaces.heima.demo02;

import java.lang.reflect.Method;

public class MyInterfaceImpl /*extends Object*/ implements MyInterfaceA, MyInterfaceB {
    @Override
    public void methodA() {
        System.out.println("覆盖重写了A方法");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖重写了B方法");
    }


    //如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需覆盖重写一次即可
    @Override
    public void methodAbs() {
        System.out.println("覆盖重写了AB接口都有的抽象方法");
    }

    //如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写
    public void methodDefault() {
        System.out.println("对多个接口当中冲突的默认方法进行了覆盖重写");
    }
}
