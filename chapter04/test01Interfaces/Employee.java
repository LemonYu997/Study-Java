//4.1 接口
package chapter04.test01Interfaces;

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 比较员工的薪水
     * @param other 另一个员工对象
     * @return 负值表示当前员工薪水小于另一个员工薪水，0表示相等，正值表示大于
     * */
    public int compareTo(Employee other)
    {
        return Double.compare(salary, other.salary);
    }
}
