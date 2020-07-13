//7.1 集合 链表序列
package chapter07.test01LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @version 1.0
 * @author mly
 * */
public class LinkedListTest {
    public static void main(String[] args) {
        //创建两个链表序列
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //把b中的单词合并到a中
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        //当b中存在下一个元素
        while (bIter.hasNext()) {
            if (aIter.hasNext())
                aIter.next();           //把迭代器往后移个位置
            //在这里插入b中元素
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //每隔一个单词从b中删除
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();               //跳过一个元素
            if (bIter.hasNext()) {
                bIter.next();           //跳过下一个元素
                bIter.remove();         //删除刚刚跳过的元素
            }
        }

        System.out.println(b);

        //批量操作：从a中删除b中的所有单词
        a.removeAll(b);

        System.out.println(a);
    }
}
