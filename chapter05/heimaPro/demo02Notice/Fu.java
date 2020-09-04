package chapter05.heimaPro.demo02Notice;

/*
 * 子父类异常：
 * 1、如果父类抛出了多个异常，子类覆盖父类方法时，抛出和父类相同的异常或者是父类异常的子类或者不抛出异常
 * 2、父类方法没有抛出异常，子类覆盖该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
 *
 * 注意：
 * 父类异常是什么样，子类异常就是什么样
 * */
public class Fu {
    public void show01() throws NullPointerException, ClassNotFoundException {}
    public void show02() throws IndexOutOfBoundsException{}
    public void show03() throws IndexOutOfBoundsException{}
    public void show04() {}
}

class Zi extends Fu {
    //子类覆盖父类方法时，抛出相同的异常
    @Override
    public void show01() throws NullPointerException, ClassNotFoundException {}

    //子类覆盖父类方法时，抛出父类异常的子类
    @Override
    public void show02() throws ArrayIndexOutOfBoundsException{}

    //子类覆盖父类方法时，不抛出异常
    @Override
    public void show03() {}

    //父类方法没有抛出异常，子类覆盖该方法时也不可抛出异常
//    @Override
//    public void show04() {}

    //此时子类产生该异常，只能捕获处理try..catch，不能声明抛出throws
    @Override
    public void show04() {
        try {
            throw new Exception("编译期异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
