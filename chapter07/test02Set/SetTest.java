//7.2 散列集
package chapter07.test02Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @version 1.0
 * @author mly
 * */
public class SetTest {
    //读取输入的单词，并将他们添加到散列集中。遍历散列集中的不同单词，最后打印出单词的数量。单词以随机顺序出现。
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();        //HashSet implements Set
        long totalTime = 0;

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i<= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " millseconds.");
    }
}
