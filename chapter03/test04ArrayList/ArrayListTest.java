//3.4 泛型数组列表 ArrayList
package chapter03.test04ArrayList;

import chapter03.test03Equals.Employee;

import java.util.ArrayList;

/* ArrayList特点：
 * 1、不必指出数组大小
 * 2、使用add将任意多的元素添加到数组中
 * 3、使用size()替代length计算元素的数目
 * 4、使用a.get(i)替代a[i]访问元素       */

public class ArrayListTest {
    public static void main(String[] args) {
        //ArrayList是一个采用类型参数的泛型类
        //不必指出数组的大小
        ArrayList<Employee> staff = new ArrayList<>();

        //使用add将任意多的元素添加到数组中
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        //提升每个人的奖金
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        //输出信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
        }
    }
}

/* 对象包装器和自动装箱，注释：
 * 1、有时想将int这样的基本类型转换为对象，可以使用包装器。
 * 2、包装器有Integer、Long、Float、Double、Short、Byte、Character、Void、Boolean
 * 3、对象包装器类是不可变的，构造后不允许改变包装在其中的值，包装器类还是final，无法定义子类
 * 4、想定义一个整型数组列表，而尖括号中不允许是基本类型，因此可用对象包装器类：
 *      ArrayList<Integer> list = new ArrayList<>()     这种方式效率很低
 * 5、使用list.add(3)将自动变成list.add(Integer.valueOf(3))，这种变换称为自动装箱
 * 6、使用int n = list.get(i)将自动变成int n = list.get(i).intValue()，称为自动拆箱            */

/* 参数数量可变的方法，这样设计方法：
 * public static double max(double... values)
 * {
 *      double largest = Double.NEGATIVE_INFINITY;
 *      for (double v : values)
 *          if (v > largest)
 *              largest = v;
 *      return largest;
 * }
 * 参数中的 ... 表示可以接受任意数量的对象，因此可以像下面这样调用方法：
 * double m = max(3.1, 40.4, -5);
 * */

