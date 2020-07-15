//接口 定义默认方法
package chapter04.heima.demo01Interface.demo01;

/*
 * 从java8开始，接口允许定义默认方法。格式：
 * public default 返回值类型 方法名称(参数列表) {
 *      //方法体
 * }
 *
 * 备注：接口中的默认方法，可以解决接口升级的问题。
 * */

public interface MyInterfaceDefault {
    //抽象方法
    public abstract void methodAbs();

//    //新添加的一个抽象方法
//    public abstract void methodAbs2();

    //A和B已经实现并投入使用，此时若要添加新的方法，如果还需要覆盖重写会很麻烦
    //新添加的方法，改成默认方法 public可以省略，default不能省略
    public default void methodDefault()
    {
        System.out.println("这是新添加的默认方法。");
    }
}
