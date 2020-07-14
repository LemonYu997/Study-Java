//构造方法
package chapter02.heima.demo01Object;

public class Demo09Teacher {
    public static void main(String[] args) {
        Teacher tea1 = new Teacher();                       //执行了无参数构造方法
        System.out.println("---------------");

        Teacher tea2 = new Teacher("Jack", 23);  //执行了有参数构造方法
        System.out.println("姓名：" + tea2.getName() + ", 年龄：" + tea2.getAge());
        //如果需要改变对象当中成员变量数据内容，仍然需要setXxx内容
        tea2.setAge(24);
        System.out.println("姓名：" + tea2.getName() + ", 年龄：" + tea2.getAge());
    }
}
