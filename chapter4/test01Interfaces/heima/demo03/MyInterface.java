package chapter4.test01Interfaces.heima.demo03;

//接口与接口之间是多继承的。
//这里继承接口A和接口B
public interface MyInterface extends MyInterfaceA, MyInterfaceB {
    public abstract void method();

    /* 这个接口当中有几个方法（添加default方法前）？
     * 答：4个
     * methodA 来源于接口A
     * methodB 来源于接口B
     * methodCommon 来源于接口A和B
     * method 来源于自己
     *                            */


    @Override
    default void methodDefault() {

    }

    //多个父接口当中的默认方法如果重复，会出问题。
}

