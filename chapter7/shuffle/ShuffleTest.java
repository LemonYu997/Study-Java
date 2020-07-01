//7.6 算法 排序——混排
package chapter7.shuffle;

/* 说明：
 * 用1~49之间的49个Integer对象填充数组，然后随机打乱列表，
 * 并从打乱后的列表中选前6个值，最后再将选择的数值进行排序和打印      */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 这个例程运用了随机混排和排序算法
 * @version 1.0
 * @author mly
 * */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
        //混排
        Collections.shuffle(numbers);
        //取6个元素
        List<Integer> winningCombination = numbers.subList(0, 6);
        //重新排序
        Collections.sort(winningCombination);
        //输出
        System.out.println(winningCombination);
    }
}
