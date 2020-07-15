package chapter03.heima.demo01Extends.demo02Field;

public class Fu {
    int numFu = 10;

    int num = 100;

    public void methodFu() {
        //使用的是本类当中的，不会向下找子类
        System.out.println(num);    //100
    }
}
