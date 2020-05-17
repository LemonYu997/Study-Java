//3.3 Object类       equals、hashCode、toString
package chapter3.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    //构造器
    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;                                   //形参和对象成员同名，为了不混淆使用this.来表示对象成员
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);           //LocalDate.of()方法修改年月日
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

    //equals方法，检测一个对象是否等于另外一个对象
    /*  由于Object类中含有这个方法，所以需要重新定义，Object类中原方法如下：
     *   public boolean equals(Object obj) {
     *      return (this == obj);
     * }                   */
    //1、显式参数命名为otherObject，稍后将它转化为另一个叫做other的变量
    public boolean equals(Object otherObject)
    {
        //2、检测this与otherObject是否引用同一个对象
        if (this == otherObject)
            return true;

        //3、检测otherObject是否为null，如果为null，返回false
        if (otherObject == null)
            return false;

        //4、比较this与otherObject是否属于同一个类
        if (getClass() != otherObject.getClass())
            return false;
        /* 注释：
         * getClass()方法，返回包含对象信息的类对象。
         * 如果equals语义在每个子类中有所改变，就使用getClass检测
         * 如果所有子类使用统一的equals语义，就使用instanceof检测：
         * if (!(otherObject instanceof ClassName))
         *      return false                                    */

        //5、现在知道otherObject不是一个空对象，将otherObject转换为相应的类类型变量
        Employee other = (Employee) otherObject;

        //6、开始对需要进行比较的域进行比较，所有的域都匹配就返回true，否则返回false
        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
        /* 注释：
         * 为了防备name和hireDay可能为null的情况，需要使用Objects.equals方法。如果两个参数都为null，
         * Objects.equals(a, b)调用将返回true；如果其中一个参数为null，则返回false；否则，两个参数
         * 都不为null，则调用a.equals(b)*/
    }

    //hashCode方法，计算散列码
    public int hashCode()
    {
        return Objects.hash(name, salary, hireDay);
    }
    /*注释：
    * 1、这里的hash算法为：
    *   int hash = 0
    *   for (int i = 0; i < length(); i++)
    *       hash = 31 * hash + charAt(i)
    * 2、hashCode方法定义在Object类中，每个对象都有一个默认的散列值，为对象的存储地址*/

    //toString方法，返回表示对象值的字符串
    public String toString()
    {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
    /*注释：
    * 1、getClass().getName()方法得到类名，方便子类进行调用
    * 2、Object类中定义了toString方法，用来打印输出对象所属的类名和散列码
    * 3、toString方法是一种非常有用的调试工具，强烈建议为每个类增加一个toString方法*/
}

/*equals方法的Java语言规范要求：
* 1)自反性：对于任何非空引用x，x.equals(x)应该返回true
* 2)对称性：对于任何引用x和y，当且仅当y.equals(x)返回true，则x.equals(y)也返回true
* 3)传递性：对于任何引用x、y、z，如果x.equals(y)返回true，y.equals(z)返回true，则x.equals(z)也应该返回true
* 4)一致性：如果x和y引用的对象没有发生变化，反复调用x.equals(y)应该返回同样的结果
* 5)对于任意非空引用x，x.equals(null)应该返回false   */
