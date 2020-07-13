//2.5 方法参数
package chapter02;

//方法参数：基本数据类型和对象引用，都使用传值调用
public class Test05ParamTest {
    public static void main(String[] args) {
        //测试1：一个方法不能修改一个基本数据类型的参数（即数据型或布尔型）
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        //测试2：方法可以改变一个对象的参数状态
        System.out.println("\nTesting tripleSalary:");
        Employee3 harry = new Employee3("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        //测试3：一个方法不能让对象参数引用一个新的对象
        System.out.println("\nTesting swap:");
        Employee3 a = new Employee3("Alice", 70000);
        Employee3 b = new Employee3("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    //不能达成效果，参数是基本数据类型
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    //能够达成效果，对象引用
    public static void tripleSalary(Employee3 x)
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee3 x, Employee3 y)
    {
        Employee3 temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }

}

//简单的类
class Employee3
{
    private String name;
    private double salary;

    public Employee3(String n, double s)
    {
        name = n;
        salary = s;
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
}