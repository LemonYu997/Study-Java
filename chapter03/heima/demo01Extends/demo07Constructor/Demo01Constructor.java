package chapter03.heima.demo01Extends.demo07Constructor;

/*
 * 继承关系中，父子类构造方法的访问特点：
 *
 * 1、子类构造方法当中有一个默认隐含的"super()"调用，所以一定是先调用的父类构造，后执行的子类构造
 * 2、可以通过supper关键字来子类构造调用父类重载构造
 * 3、super的父类构造调用，必须是子类构造方法的第一个语句。
 * 总结：
 * 子类必须调用父类构造方法，不写则赠送super();
 * 写了则用写的指定的super调用，super只有一个，还必须是那一个
 * */

public class Demo01Constructor {
    public static void main(String[] args) {
        //先执行父类构造方法，再执行子类构造方法
        Zi zi = new Zi();
    }
}
