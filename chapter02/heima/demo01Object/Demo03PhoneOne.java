package chapter02.heima.demo01Object;

public class Demo03PhoneOne {
    public static void main(String[] args) {
        //根据Phone类，创建一个名为phone的对象
        //格式：类名称 对象名 = new 类名称();
        Phone one = new Phone();
        System.out.println(one.brand);      //null
        System.out.println(one.price);      //0.0
        System.out.println(one.color);      //null
        System.out.println("-----------------------");

        one.brand = "Apple";
        one.price = 8388.0;
        one.color = "Black";
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
        System.out.println("-----------------------");

        //使用方法
        one.call("Jobs");
        one.sendMessage();
    }
}
