//3.7 反射part2 在运行时用反射分析对象
package chapter3.objectAnalyzer;

import java.util.ArrayList;

/**
 * 利用反射分析对象
 * @author mly
 * */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
