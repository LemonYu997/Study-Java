//对象的向上转型和向下转型
package chapter04.heima.demo02Multi.demo03;

/*
 * 向上转型一定是安全的，没有问题的，正确的，但是有一个弊端：
 * 对象一旦向上转型为父类，那么就无法调用子类原本特有的内容。
 *
 * 解决方案：用对象的向下转型【还原】
 *
 * */
public class Demo01Main {
    public static void main(String[] args) {
        //对象的向上转型，就是父类引用指向子类对象
        Animal animal = new Cat();
        animal.eat();

//        animal.catchMouse();    //错误写法！

        //向下转型，进行"还原"动作
        Cat cat = (Cat) animal;
        cat.catchMouse();         //猫抓老鼠

        //下面是错误的向下转型
        //本来new的时候是一只猫，现在非要做狗
        //编译不会报错，运行会出现异常
//        Dog dog = (Dog) animal; //类转换异常 java.lang.ClassCastException
    }
}
