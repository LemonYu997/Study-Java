//2.3 类的学习     用户自定义类
package chapter2;

import java.time.LocalDate;

/*注释：
* 本程序包含两个类：Employee类和带有public访问修饰符的 EmployeeTest类，EmployeeTest类包含了main方法
* 源文件名为EmployeeTest.java，文件名必须与public类名字相匹配，只能有一个公有类，但可以有任意数目的非公有类
* 编译下述代码时，编译器将创建两个类文件：Employee.class和EmployeeTest.class
* */

//Employee类的实际运用
public class Test03EmployeeTest {
    public static void main(String[] args) {
        //创建三个员工对象
        Employee[] staff = new Employee[3];

        //初始化
        staff[0] = new Employee("Carl Creaker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        //每个人工资涨5%
        for (Employee e : staff) {
            e.raiseSalary(5);
            /*在这里，e是隐式参数，5是显式参数*/
        }

        //输出员工对象的信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
        }
    }
}

//自定义创建Employee类
class Employee
{
    //实例字段  设置私有数据域
    private String name;                //名字
    private double salary;              //工资
    private LocalDate hireDay;          //工作时间

    /*private标识的实例域表示只有Employee类自身的方法能够访问，其他类的方法不能对其进行读写
    * public标识的方法表示任何类任何方法都可以调用
    * 不要用public标记实例域，因为会破坏封装*/
    //构造函数  和类名相同，伴随着new操作符的执行而被调用
    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }
    /*构造函数的特点：
    * 1、构造器与类同名
    * 2、每个类可以有一个以上的构造器
    * 3、构造器可以有0个、1个或多个参数
    * 4、构造器没有返回值
    * 5、构造器总是伴随着new操作符一起调用*/

    //方法：得到名字               访问器
    public String getName()
    {
        return name;
    }

    //方法：得到工资               访问器
    public double getSalary()
    {
        return salary;
    }

    //方法：得到工龄               访问器
    public LocalDate getHireDay()
    {
        return hireDay;
    }

    //方法：涨工资                 更改器
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}