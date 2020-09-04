//finally中有return语句时
package chapter05.heimaPro.demo02Notice;

/*
 * 如果finally有return语句，永远返回finally中的结果
 * 一般要避免该情况，尽量不在finally中写return语句
 * */
public class Demo02Finally {
    public static void main(String[] args) {
        int a = getA();
        System.out.println(a);      //100
    }

    //定义一个方法，返回变量a的值
    public static int getA() {
        int a = 10;
        try {
            return a;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //一定会执行的代码
            a = 100;
            return a;
        }
    }
}
