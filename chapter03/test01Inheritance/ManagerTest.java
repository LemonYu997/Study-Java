//3.1 继承
package chapter03.test01Inheritance;

//主体部分，用到了Employee超类和Manage子类
public class ManagerTest {
    public static void main(String[] args) {
        //建立一个Manager对象
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);


        Employee[] staff = new Employee[3];

        //用Manager和Employee对象填充staff数组
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        /* 超类变量既可以引用超类对象也可以引用子类对象，这种情况就是多态
         * staff[0]是Employee对象，boss是Manager对象
         * 调用setBonus()方法时必须是boss. 不能用staff[0]调用
         * 注意：不能将超类对象赋给子类变量*/

        //输出信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
        /*注释：
        * 在这里，e.getSalary()会自动区分对象，选择调用超类还是子类中的方法
        * 尽管e引用的是Employee对象，实际上它还能引用Manager对象。
        * 当e引用Manager对象(boss)时，会调用Manager类中的getSalary()方法
        * 一个对象变量（如：e）指示多种实际类型的现象被称为 <多态>
        * 在运行时自动选择调用哪个方法的现象称为动态绑定。*/
    }
}
