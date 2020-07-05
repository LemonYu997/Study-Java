//接口 静态方法
package chapter4.test01Interfaces.heima.demo01;

/* 从java 8开始，接口当中允许定义静态方法，格式：
 * public static 返回值类型 方法名成(参数列表) {
 *      //方法体
 * }
 *
 * 提示：将abstract或default关键字换成static即可，带上方法体。
 * */

public interface MyInterfaceStatic {

    public static void methodStatic() {
        System.out.println("这是接口的静态方法！");
    }

}
