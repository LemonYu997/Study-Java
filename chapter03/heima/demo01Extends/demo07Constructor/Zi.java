package chapter03.heima.demo01Extends.demo07Constructor;

public class Zi extends Fu {

    public Zi() {
//        super();        //默认隐含，在调用父类无参构造方法
        super(10);  //在调用父类重载的构造方法
        System.out.println("子类构造方法！");
    }

    public void method() {
        //错误写法！只有子类构造方法，才能调用父类构造方法
//        super();
    }

}
