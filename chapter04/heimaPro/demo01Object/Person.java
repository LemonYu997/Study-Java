package chapter04.heimaPro.demo01Object;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * 直接打印对象的地址值没有意义，所以需要重写Object中的toString方法
     * 打印对象的属性(name, age)
     * */
//    @Override
//    public String toString() {
//        return "Person{name = " + name + ", age = " + age + "}";
//    }

    //使用快捷键
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
     * Object类的equals方法，默认比较的是两个对象的地址值，没有意义
     * 所以重写equals方法，比较两个对象的属性(name, age)
     * 问题：
     *      隐含着一个多态，多态的弊端：无法使用子类特有的内容
     *      object obj = p2 = new Person("Tom", 20);
     * 解决方法：
     *      使用向下转型(强转)把obj类型转换为Person
     * */

    /*@Override
    public boolean equals(Object obj) {
        //重写后有新问题，equals方法中的参数是Object类，在
        // Person类中使用了强转，此时若用其他类作为参数
        //会产生ClassCastException异常

        //增加一个判断，传递的参数obj如果是this本身，直接返回true
        //提高程序效率
        if (obj == this) {
            return true;
        }

        //增加一个判断，传递的参数obj如果是null，直接返回false
        //可以提高程序的效率
        if (obj == null) {
            return false;
        }

        //增加一个判断，防止ClassCastException异常
        if (obj instanceof Person) {
            //使用向下转型，把obj转换为Person类型
            Person p = (Person)obj;
            //比较两个对象的属性，一个对象是this(p1)，一个对象是p(obj->p2)
            //这里用的equals方法是String类中重写的，可以比较内容是否相等
            boolean b = this.name.equals(p.name) && this.age == p.age;
            return b;
        }

        //不是Person类型，直接返回false
        return false;
    }*/

    //使用快捷键直接创建
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass() 使用反射技术，判断o是否是Person类型
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
