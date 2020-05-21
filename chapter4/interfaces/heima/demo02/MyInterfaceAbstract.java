//继承父类并实现多个接口
package chapter4.interfaces.heima.demo02;

//如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类必须是一个抽象类
public abstract class MyInterfaceAbstract implements MyInterfaceA, MyInterfaceB {
    @Override
    public void methodA() {

    }

    @Override
    public void methodAbs() {

    }

    //抽象类中有重复的也要进行重写
    //如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写
    public void methodDefault() {
        System.out.println("对多个接口当中冲突的默认方法进行了覆盖重写");
    }
}
