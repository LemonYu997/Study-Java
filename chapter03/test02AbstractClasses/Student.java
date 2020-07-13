package chapter03.test02AbstractClasses;

public class Student extends Person{
    private String major;
    /**
     * @param name 是学生的姓名
     * @param major 是学生的专业
    */
    //构造器
    public Student(String name, String major)
    {
        //调用超类（这里是抽象类的）构造器
        super(name);
        this.major = major;
    }

    //子类中必须包含抽象类中的抽象方法，子类中的抽象方法可以是抽象的也可以是具体的
    public String getDescription()
    {
        return "a student majoring in " + major;
    }
}
