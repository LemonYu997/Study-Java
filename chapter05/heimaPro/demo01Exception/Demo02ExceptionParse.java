//异常解析过程
package chapter05.heimaPro.demo01Exception;

/*
 * 异常的产生过程解析(分析异常是怎么产生的，如何处理异常)
 *
 * 访问数组中的3索引，而数组是没有3索引的，JVM会检测出程序会出现异常
 * JVM做两件事：
 *      1、JVM会根据一场产生的原因创建一个异常对象，这个异常对象包含了异常产生的(内容、原因、位置)
 *          new ArrayIndexOutOfBoundsException("3");
 *      2、在getElement方法中，没有异常的处理逻辑(try...catch)，那么JVM就会把异常对象抛出给方法的调用者main方法来处理这个异常
 *         main方法接收到异常对象，但main方法也没有异常的处理逻辑，继续把对象抛出给main方法的调用者JVM
 *         JVM接收到这个异常对象，做两件事：
 *              1、把异常产生的(内容、原因、位置)以红色字体打印到控制台
 *              2、JVM会终止当前正在执行的java程序 --> 中断处理
 * */
public class Demo02ExceptionParse {
    public static void main(String[] args) {
        //创建int类型的数组并复制
        int[] arr = {1, 2, 3};
        int e = getElement(arr, 3);     //ArrayIndexOutOfBoundsException: 3
        System.out.println(e);
    }

    /*
     * 定义一个方法，获取数组指定索引处的元素
     * 参数：
     *      int[] arr
     *      int index
     * */
    public static int getElement(int[] arr, int index) {
        int ele = arr[index];
        return ele;
    }
}
