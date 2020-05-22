//4.3  对象克隆
package chapter4.clone;

/**
 * Clone程序的Demo
 * @author mly
 * */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);

            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);

            /* 注意：
             * 这里体现的是，重写了Cloneable接口中的clone方法实现
             * 方便实现深度克隆，即克隆对象中引用的其他对象*/

            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
