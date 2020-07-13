//2.7 包的导入Part2，Part1中用到的类放在这个文件中
package chapter02;                   //这个类放在这个包中

import java.time.LocalDate;         //导入java包，import语句位于package语句之后

//定义为public的公有类，可以被任意类使用，没有public或private的类可以被同一个包中的所有方法访问
public class Employee5 {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee5(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

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

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
