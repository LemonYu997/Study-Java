//7.5 映射
package chapter7.test05Map;

/* 说明：
 * Java类库中有两个通用映射：HashMap和TreeMap
 * 一般用HashMap。
 * Map核心是一个key对应一个value，不能一个key对应两个value，也不能有两个同名key */

import chapter3.test03Equals.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个映射(Map)例程，键(Key)为String类型，值为Employee类
 * @version 1.0
 * @author mly
 * */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee", 12000, 1965, 10, 5));
        staff.put("567-24-2546", new Employee("Harry Hacker", 15000, 1977, 12, 5));
        staff.put("157-62-7935", new Employee("Gary Cooper", 20000, 1955, 5, 3));
        staff.put("456-62-5527", new Employee("Francesca Cruz", 55555, 1999, 4, 15));

        //输出所有条目
        System.out.println(staff);

        //删除一个条目
        staff.remove("567-24-2546");

        //替换一个条目
        staff.put("456-62-5527", new Employee("Fracesca Miller", 66666, 1994, 2, 11));

        //查询一个值
        System.out.println(staff.get("157-62-7935"));

        //遍历所有条目
        staff.forEach((k, v) -> System.out.println("Key=" + k + ", value=" + v));
    }
}
