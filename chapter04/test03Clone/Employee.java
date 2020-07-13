package chapter04.test03Clone;

import java.util.Date;
import java.util.GregorianCalendar;

//克隆接口的实现类
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    //构造器
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    //克隆实现，这个方法本来是在Object中的，这里进行重定义
    public Employee clone() throws CloneNotSupportedException {                 //抛出异常
        //调用Object.clone()
        Employee cloned = (Employee) super.clone();

        //克隆对象中的可变实例域
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * 将hireDay设置为给定的日期
     * @param year hireDay中的年份
     * @param month hireDay中的月份
     * @param day hireDay中的日子
     * */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        //改变可变域
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
    }
}
