//3.3 Object类       equals、hashCode、toString
package chapter3.test03Equals;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day)
    {
        //调用超类构造器
        super(name, salary, year, month, day);
        bonus = 0;
    }

    //重新定义getSalary()方法
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject)
    {
        //先调用超类中的equals方法进行检测
        if (!super.equals(otherObject))
            return false;
        Manager other = (Manager) otherObject;
        //前边的使用超类中的equals方法进行过比较了，这里只用比较bonus是否相等
        return bonus == other.bonus;
    }

    public int hashCode()
    {
        //相比超类多了一个bonus要计算
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    public String toString()
    {
        //同上
        return super.toString() + "[bonus=" + bonus + "]";
    }

}
