//黑马 面向对象
package chapter02.heima.demo01Object;

/*
 * 面向过程：当需要实现一个功能时，每一个具体步骤都要亲历亲为，详细处理每一个细节
 * 面向对象：当需要实现一个功能时，不关心具体的步骤，找一个已经具有该功能的人帮我做事
 * */

import java.util.Arrays;

public class Demo01PrintArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        //打印格式为：[10, 20, 30, 40, 50]
        //使用面向过程，每一个步骤都要亲历亲为
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            //如果是最后一个元素
            if (i == array.length - 1){
                System.out.println(array[i] + "]");
            } else {    //如果不是最后一个元素
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("-----------------------");

        //使用面向对象
        //找一个JDK给我们提供好的Arrays类
        //其中有一个toString方法，直接能把数组变成想要的格式的字符串
        System.out.println(Arrays.toString(array));
    }
}
