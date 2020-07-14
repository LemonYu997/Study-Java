package chapter02.heima.demo01Object;

/*
 *【重点】
 * 通过谁调用的方法，谁就是this
 * */
public class Demo08ThisTest {
    public static void main(String[] args) {
        ThisTest person = new ThisTest();

        //设置自己的名字
        person.name = "Jack";
        person.sayHello("Tom");

        System.out.println(person);
    }
}
