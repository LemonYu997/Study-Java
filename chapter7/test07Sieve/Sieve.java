//7.7 位集BitSet运用，删选素数
package chapter7.test07Sieve;

/* 说明：
 * 素数：只能被1和本身整除的数（1不是素数）
 * 计算2~2000000之间的所有素数并打印（共有148933个素数）
 * 遍历200万个位的位集，先将所有位置设为"开"，然后将已知素数的倍数所对应的位都置为"关"
 * 最后保留下来的位对应的就是素数*/

import java.util.BitSet;

/**
 * 运用Erathostenes筛选法，选出2000000以内的素数
 * @version 1.0
 * @author mly
 * */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);

        int count = 0;
        int i = 0;

        //全部设为 开
        for (i = 0; i <= n; i++) {
            b.set(i);
        }

        //素数筛选
        i = 2;
        //i*i <= n的目的是减少重复关掉的运算，在这里可以得到1414内的素数
        while(i*i <= n) {
            if (b.get(i)) {
                count++;
                //关掉所有i的倍数
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }

        //筛选剩下的素数
        while (i <= n) {
            if (b.get(i))
                count++;
            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
