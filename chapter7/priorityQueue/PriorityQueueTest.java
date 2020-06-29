//7.4 优先级队列
package chapter7.priorityQueue;

/* 说明：
 * 元素可以按照任意的顺序插入，但总是按照排序的顺序进行检索。
 * 下面的程序中，删除会删掉剩余元素中优先级数最小（优先级最高）的元素。*/

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 优先级队列示范程序
 * @version 1.0
 * @author mly
 * */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));      //G.Hopper
        pq.add(LocalDate.of(1815, 12, 10));     //A.Lovelace
        pq.add(LocalDate.of(1903, 12, 3));      //J.von Neumann
        pq.add(LocalDate.of(1910, 6, 22));      //K.Zuse

        //随机顺序添加到队列中
        System.out.println("Iterating over elements...");
        for (LocalDate date: pq) {
            System.out.println(date);
        }

        //依次删除最小的元素
        System.out.println("Removing elements...");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
