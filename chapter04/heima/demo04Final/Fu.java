//final关键字用来修饰一个方法
package chapter04.heima.demo04Final;

/*
 * 当final关键字用来修饰一个方法的时候，这个方法就是最终方法，也就是不能覆盖重写
 * 格式：
 * 修饰符 final 返回值类型 方法名称(参数列表) {
 *      //方法体
 * }
 * 注意事项：
 * 对于类、方法，abstract关键字和final关键字不能同时使用，因为矛盾
 * */
public class Fu {
    public final void method() {
        System.out.println("父类方法执行！");
    }

    //矛盾
//    public abstract final void methods();     错误写法
}
