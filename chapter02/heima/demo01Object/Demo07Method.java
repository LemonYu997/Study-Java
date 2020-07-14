package chapter02.heima.demo01Object;

/*
 * 面向对象三大特征：封装、继承、多态
 *
 * 封装性在Java中的体现
 * 1、方法就是一种封装
 * 2、关键字private也是一种封装
 *
 * 封装就是将一些细节信息隐藏起来，对外界不可见
 *
 * 问题描述：定义Person的年龄时，无法阻止不合理的数值被设置进来
 * 解决方案：用private关键字将需要保护的成员变量进行修饰
 *
 * 一旦使用了private进行修饰，那么本类当中仍然可以随意访问。
 * 但是！超出了本类范围之外就不能再直接访问了
 *
 * 间接访问private成员变量，就是定义一对Setter/Getter方法
 *
 * 命名方法必须是：setXxx或是getXxx
 * 对于Getter来说，不能有参数，返回值类型和成员变量对应
 * 对于Setter来说，不能有返回值，参数类型和成员变量对应
 * */

public class Demo07Method {
    public static void main(String[] args) {
        //方法封装
        int[] array = {5, 15, 25, 20, 100};

        int max = getMax(array);
        System.out.println("最大值：" + max);
        System.out.println("-----------------------");

        //关键字private封装
        Person person = new Person();
        person.show();

        person.name = "Jack";
//        person.age = -20;           //private修饰后其他类无法直接访问
        person.setAge(20);
        person.show();
    }

    //返回最大值
    public static int getMax(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
