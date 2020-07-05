//数组作为方法参数
package chapter1.heima.Demo05Array;

/*
 * 数组可以作为方法的参数
 * 当调用方法的时候，向方法的小括号进行传参，传递进去的其实是数组的地址值
 * */

public class Demo05ArrayParam {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        System.out.println(array);          //地址值
        System.out.println("-------------------------");

        System.out.println("第一次：");
        printArray(array);                  //传递进去的就是array当中保存的地址值
        System.out.println("第二次：");
        printArray(array);
        System.out.println("第三次：");
        printArray(array);
    }

    /*
     * 三要素
     * 返回值类型：只是进行打印，void
     * 方法名称：printArray
     * 参数列表：int[] array
     * */
    public static void printArray(int[] array) {
        System.out.println("printArray方法收到的参数是：");
        System.out.println(array);          //地址值
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-------------------------");
    }
}
