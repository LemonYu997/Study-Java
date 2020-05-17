package chapter3.abstractClasses;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        //创建people数组使用两个不同的子类
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "Computer science");

        //输出信息
        //抽象类的好处体现在这里，通过定义一个变量调用不同子类对象的不同方法
        for (Person p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
        /*由于不能构造抽象类Person的对象，所以变量p不会引用Person对象，
        * 而是根据动态绑定引用Employee对象和Student对象。
        * 这些对象中都定义了getDescription()方法*/
    }
}
/*Java用于控制可见性的4个访问修饰符，总结：
* 1）仅对本类可见————private
* 2）对所有类可见————public
* 3）对本包和所有子类可见————protected
* 4）对本包可见————默认，不需要修饰符*/