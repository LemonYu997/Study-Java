//3.2 抽象类
package chapter3.abstractClasses;

import java.time.LocalDate;

//Person抽象类的子类Employee
public class Employee extends Person {
    private double salary;
    private LocalDate hireDay;

    //构造器
    public Employee(String name, double salary, int year, int month, int day)
    {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    //子类中必须包含抽象类中的抽象方法，子类中的抽象方法可以是抽象的也可以是具体的
    public String getDescription()
    {
        return String.format("an employee with a salary of $%.2f", salary);
        /* String类的format()方法用于创建格式化的字符串以及连接多个字符串对象。类似C语言的sprintf()方法，format()方法有两种重载形式：
         * format(String format, Object... args) 新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。
         * format(Locale locale, String format, Object... args) 使用指定的语言环境，制定字符串格式和参数生成格式化的字符串。*/
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
