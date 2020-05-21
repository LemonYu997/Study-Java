package chapter4.interfaces.heima.demo01;

import chapter4.interfaces.heima.demo01.MyInterfacePrivateA;

public class MyInterfacePrivateAImpl implements MyInterfacePrivateA {

    public void methodAnother() {
        //直接访问到了接口中的默认方法，这样是错误的！
//        methodCommon1();
    }
}
