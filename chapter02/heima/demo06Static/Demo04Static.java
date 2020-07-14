//静态代码块
package chapter02.heima.demo06Static;

/*
 * 特点：当第一次用到本类时，静态代码块执行唯一的一次
 * 静态的内容总是优先于非静态，所以静态代码块方法先执行
 * */

public class Demo04Static {
    public static void main(String[] args) {
        Person one = new Person();
        Person two = new Person();
    }
}
