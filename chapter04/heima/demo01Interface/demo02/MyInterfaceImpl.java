//继承父类并实现多个接口
package chapter04.heima.demo01Interface.demo02;

/* 使用接口时要注意：
 * 1、接口是没有静态代码块或者构造方法的。
 * 2、一个类的直接父类是唯一的，但是一个类可以同时实现多个接口。
 *    格式：
 *    public class MyInterfaceImpl implements MyInterfaceA, MyInterfaceB {
 *          //覆盖重写所有抽象方法
 *    }
 * 3、如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需覆盖重写一次即可。
 * 4、如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类必须是一个抽象类
 * 5、如果实现类所实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写
 * 6、一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法*/

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
