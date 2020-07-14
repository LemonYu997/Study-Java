//内存
package chapter02.heima.demo06Static;

public class Demo03StaticStudent {
    public static void main(String[] args) {
        //首先设置一下教室，是静态内容，应该通过类名称进行调用
        Student.room = "101";

        Student one = new Student("Jack", 20);
        System.out.println("one的姓名：" + one.getName());
        System.out.println("one的年龄：" + one.getAge());
        System.out.println("one的教室：" + Student.room);

        Student two = new Student("Tom", 18);
        System.out.println("two的姓名：" + two.getName());
        System.out.println("two的年龄：" + two.getAge());
        System.out.println("two的教室：" + Student.room);
    }
}
