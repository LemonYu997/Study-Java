//2.4 静态方法学习
package chapter2;

public class StaticTest {
    public static void main(String[] args) {
        //创建三个员工对象
        Employee2[] staff = new Employee2[3];

        staff[0] = new Employee2("Tom", 40000);
        staff[1] = new Employee2("Dick", 60000);
        staff[2] = new Employee2("Harry", 65000);

        //输出信息
        for (Employee2 e : staff) {
            e.setId();                      //设置ID
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }

        //使用静态方法
        int n = Employee2.getNextId();
        System.out.println("Next available id = " + n);
    }
}

class Employee2
{
    //静态域，独属于类，不属于某个对象
    private  static int nextId = 1;

    //私有域
    private String name;
    private double salary;
    private int id;

    //构造器
    public Employee2(String n, double s)
    {
        name = n;
        salary = s;
        id = 0;
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

    public int getId()
    {
        return id;
    }

    //更改器
    public void setId()
    {
        id = nextId;
        nextId++;
    }

    //更改静态域
    public static int getNextId()
    {
        return nextId;
    }

    //main方法
    public static void main(String[] args) {
        Employee2 e = new Employee2("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}