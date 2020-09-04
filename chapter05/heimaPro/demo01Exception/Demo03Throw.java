//throw关键字
package chapter05.heimaPro.demo01Exception;

/*
 * throw关键字作用：
 *      可以使用throw关键字在指定的方法中抛出指定的异常
 * 使用格式：
 *      throw new xxxException("异常产生的原因");
 * 注意：
 *      1、throw关键字必须写在方法的内部
 *      2、throw关键字后边new的对象必须是Exception或者Exception的子类对象
 *      3、throw关键字抛出指定的异常对象，我们就必须处理这个异常对象
 *          throw关键字后边创建的是RuntimeException或者是RuntimeException的子类对象，
 *          我们可以不处理，交给JVM处理(打印异常对象，中断程序)
 *          throw关键字后边创建的是编译异常，我们就必须处理这个异常，要么throws，要么try...catch
 * */
public class Demo03Throw {
    public static void main(String[] args) {
        //int[] arr = null;
        int[] arr = new int[3];
//        int e = getElement(arr, 0);     //NullPointerException: 传递的数组的值是空
        int e = getElement(arr, 3); //ArrayIndexOutOfBoundsException: 传递的索引超出了数组的使用范围
        System.out.println(e);
    }
    /*
     * 定义一个方法，获取数组指定索引处的元素
     * 参数：
     *      int[] arr
     *      int index
     * 【注意】：以后在工作中，首先必须对方法传递过来的参数进行合法性校验
     * 如果参数不合法，必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题
     * */
    public static int getElement(int[] arr, int index) {
        /*
         * 可以对传递过来的数组进行合法性校验，
         * 如果数组arr的值是null，那么我们抛出空指针异常，告知方法的调用者"传递的数组的值是空"
         * 注意：空指针异常NullPointerException是运行期异常，不用处理，默认交给JVM
         * */
        if (arr == null) {
            throw new NullPointerException("传递的数组的值是空");
        }

        /*
         * 对传递过来的参数index进行合法性校验
         * 如果index的范围不在数组的索引范围内，那么就抛出数组索引越界异常，告知方法的调用者"传递的索引超出了数组的使用范围"
         * */
        if (index < 0 || index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }

        int ele = arr[index];
        return ele;
    }
}
