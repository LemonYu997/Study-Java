//局部内部类
package chapter04.heima.demo06InnerClass;

/*
 * 如果一个类是定义在一个方法内部的，那么就是一个局部内部类
 * "局部"：只有当前所属的方法才能使用它，出了这个方法外面就不能用了
 *
 * 定义格式：
 * 修饰符 class 外部类名称 {
 *      修饰符 返回值类型 外部类方法名称(参数列表) {
 *          class 局部内部类名称 {
 *              //...
 *          }
 *      }
 * }
 *
 * */
public class Outer2 {
    //外部类方法
    public void methodOuter() {
        //局部内部类
        class Inner {
            //局部内部类变量
            int num = 10;
            //局部内部类方法
            public void methodInner() {
                System.out.println(num);
            }
        }

        //该方法内创建局部内部类并调用方法
        Inner inner = new Inner();
        inner.methodInner();
    }
}
