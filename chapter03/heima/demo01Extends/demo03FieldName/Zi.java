package chapter03.heima.demo01Extends.demo03FieldName;

public class Zi extends Fu {

    int num = 20;

    public void method() {
        int num = 30;
        System.out.println("局部变量，num：" + num);                  //30 局部变量
        System.out.println("本类成员变量，this.num：" + this.num);    //20 本类成员变量
        System.out.println("父类成员变量，super.num：" + super.num);  //10 父类成员变量
    }
}
