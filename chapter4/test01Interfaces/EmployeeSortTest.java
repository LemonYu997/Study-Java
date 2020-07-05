//4.1 接口
package chapter4.test01Interfaces;

import java.util.Arrays;

/**
 * 学习使用Comparable接口
 * @author mly
 * */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        //排序
        Arrays.sort(staff);

        //输出信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}
