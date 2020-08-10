//类的构造器的方法引用    Class::new
package chapter15.heimaPro.demo03MethodReference;

public class Demo06ConstructorMethodReference {
    //定义一个方法，参数传递姓名和PersonBuilder接口，方法中通过姓名创建Person对象
    public static void printName(String name, PersonBuilder pb) {
        Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        //调用printName方法，方法的参数PersonBuilder接口是一个函数式接口，使用Lambda表达式
        printName("苍蓝星", (String name) -> {
            return new Person(name);
        });

        /*
         * 使用方法引用优化Lambda表达式
         * 构造方法new Person(String name)已知
         * 创建对象已知 new
         * 就可以使用Person引用new来创建对象
         * */
        printName("苍蓝星", Person::new);      //根据Person类的带参构造方法，通过传递的姓名创建对象
    }
}
