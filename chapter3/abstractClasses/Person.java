//3.2 抽象类
package chapter3.abstractClasses;

//一个抽象类
//在class前加上abstract关键字就表示是抽象类，方便连接接口和实例
public abstract class Person {
    //加上abstract的方法就是抽象方法，含有抽象方法的类必须声明为抽象类
    //抽象方法的作用主要是占位，具体实现则在子类中
    public abstract String getDescription();
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
