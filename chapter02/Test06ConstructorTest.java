//2.6 对象构造，构造器的使用
package chapter02;

import java.util.Random;

public class Test06ConstructorTest {
    public static void main(String[] args) {
        //创建三个对象
        Employee4[] staff = new Employee4[3];

        //使用三种构造器
        staff[0] = new Employee4("Harry", 40000);
        staff[1] = new Employee4(60000);
        staff[2] = new Employee4();

        //输出信息
        for (Employee4 e : staff) {
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }
    }
}

class Employee4
{
    private static int nextId;

    private int id;
    private String name = "";           //初始化
    private double salary;

    //静态初始化块，在类进行加载时就会进行静态域的初始化
    static
    {
        Random generator = new Random();
        //将nextId置为0~9999的随机数，用法就是Random类中的nextInt方法
        nextId = generator.nextInt(10000);
    }

    //对象初始化块，在调用构造器时，先运行初始化块，再运行构造器主体部分
    {
        id = nextId;
        nextId++;
    }

    //三种重载构造器
    public Employee4(String n, double s)
    {
        name = n;
        salary = s;
    }

    public Employee4(double s)
    {
        //如果构造器的第一条语句是this(...)，将调用同一个类的另一个构造器
        this("Employee #" + nextId, s);
    }

    //默认构造器
    public Employee4()
    {
        // name 初始化为""，在静态域中已经进行了初始化，否则为null
        // salary 之前没有进行过初始化，默认为0
        // id 在对象初始化块中进行了初始化
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }
}
