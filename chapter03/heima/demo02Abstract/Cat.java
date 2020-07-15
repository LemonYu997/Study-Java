package chapter03.heima.demo02Abstract;

public class Cat extends Animal {

    public Cat() {
        //super();
        System.out.println("子类构造方法执行！");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼！");
    }
}
