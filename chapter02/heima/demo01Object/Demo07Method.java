package chapter02.heima.demo01Object;

/*
 * 面向对象三大特征：封装、继承、多态
 *
 * 封装性在Java中的体现
 * 1、方法就是一种封装
 * 2、关键字private也是一种封装
 *
 * 封装就是将一些细节信息隐藏起来，对外界不可见
 * */

public class Demo07Method {
    public static void main(String[] args) {
        int[] array = {5, 15, 25, 20, 100};

        int max = getMax(array);
        System.out.println("最大值：" + max);
    }

    //返回最大值
    public static int getMax(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
