//3.1 继承
package chapter3.test01Inheritance;

//子类
public class Manager extends Employee{
    //添加一个奖金变量，相比Employee对象
    private double bonus;

    //子类构造器
    public Manager(String name, double salary, int year, int month, int day)
    {
        /*注释：
        * super():调用超类构造器的简化写法。
        * 因为子类不能直接访问超类的私有域，所以需要用超类的构造器对这部分私有域进行初始化。
        * 如果子类没有显式调用超类的构造器，将自动地调用超类默认（没有参数）的构造器。
        * 如果超类没有不带参数的构造器，子类又不显式调用其他构造器，编译器会报错*/
        super(name,salary,year,month,day);
        bonus = 0;              //对奖金变量进行初始化
    }

    //覆盖超类方法        超类为public，子类必须为public
    public double getSalary()
    {
        //超类和子类都有getSalary()方法，不加super.关键字的话会无限调用自己，需要进行标识
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    //更改器
    public void setBonus(double b)
    {
        bonus = b;
    }
}
