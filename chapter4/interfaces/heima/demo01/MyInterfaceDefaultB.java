package chapter4.interfaces.heima.demo01;

import chapter4.interfaces.heima.demo01.MyInterfaceDefault;

public class MyInterfaceDefaultB implements MyInterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法，BBB");
    }

    //覆盖重写接口中的默认方法
    @Override
    public void methodDefault() {
        System.out.println("实现类B覆盖重写了接口的默认方法");
    }
}
