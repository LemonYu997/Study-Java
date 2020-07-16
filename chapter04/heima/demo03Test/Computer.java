package chapter04.heima.demo03Test;

public class Computer {
    public void powerOn() {
        System.out.println("电脑开机");
    }

    public void powerOff() {
        System.out.println("电脑关机");
    }

    //使用USB设备的方法，使用接口作为方法的参数
    public void useDevice(USB usb) {
        usb.open();     //打开设备

        //根据不同实现类，执行不同的特有方法
        if(usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;  //向下转型
            mouse.click();
        } else if (usb instanceof Keyboard) {
            Keyboard keyboard = (Keyboard) usb;     //向下转型
            keyboard.type();
        }

        usb.close();    //关闭设备
    }
}
