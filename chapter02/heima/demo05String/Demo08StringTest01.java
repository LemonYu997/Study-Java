//String习题一
package chapter02.heima.demo05String;

/*
 * 题目：
 * 定义一个方法，把数组{1, 2, 3}按照指定格式拼接成一个字符串，格式如下：[word1#word2#word3]
 *
 * 分析：
 * 1、首先准备一个int[]数组，内容是：1、2、3
 * 2、定义一个方法，用来将数组变成字符串
 * 三要素：
 * 返回值类型： String
 * 方法名称：   fromArrayToString
 * 参数列表：int []
 * 3、格式：[word1#word2#word3]
 * 用到：for循环、字符串拼接、每个数组元素之前都有一个word字样，分隔使用#、区分是否为最后一个
 * 4、调用方法，得到返回值，打印结果
 * */

public class Demo08StringTest01 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};

        String result = fromArrayToString(array);
        System.out.println(result);
    }

    public static String fromArrayToString(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {    //最后一个元素
                str += "word" + array[i] + "]";
            } else {                        //不是最后一个元素
                str += "word" + array[i] + "#";
            }
        }

        return str;
    }
}
