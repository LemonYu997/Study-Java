package chapter04.heima.demo03Test;

public class DemoMain {
    public static void main(String[] args) {
        //首先创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();

        //准备一个鼠标，供电脑使用
//        Mouse mouse = new Mouse();
        //首先进行向上转型
        USB usbMouse = new Mouse();
        //方法参数是USB类型，传进去的就是USB鼠标
        computer.useDevice(usbMouse);

        //创建一个USB键盘
        Keyboard keyboard = new Keyboard();     //没有使用多态写法
        //方法参数是USB类型，传递进去的是实现类对象
        //实现类可以向上转型为接口
        computer.useDevice(keyboard);           //正确写法！也发生了向上转型
        //使用子类对象，匿名对象，也是可以的
//        computer.useDevice(new Keyboard());     //正确写法！



        computer.powerOff();
        System.out.println("------------------");

        method(10.0);       //正确 double --> double
        method(10);         //正确 int --> double
        int a = 30;
        method(a);               //正确 int --> double
    }

    public static void method(double num) {
        System.out.println(num);
    }
}
