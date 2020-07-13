//3.1 继承
package chapter03.test01Inheritance;

import java.time.LocalDate;

//超类
/*如果用final修饰，则表示不允许有子类继承该类：public final class Employee
* 如果方法有final标识，表示子类不能覆盖这个方法：public final double getSalary()*/
public class Employee {
    //私有域
    private String name;
    private double salary;
    private LocalDate hireDay;

    //构造器
    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    //访问器
    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    //更改器
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
