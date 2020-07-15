package chapter03.heima.demo01Extends.demo02Field;

public class Zi extends Fu {
    int numZi = 20;

    int num = 200;      //与父类成员变量重名

    public void methodZi() {
        //因为子类中有num，所以用本类的num
        System.out.println(num);    //200
    }
}
