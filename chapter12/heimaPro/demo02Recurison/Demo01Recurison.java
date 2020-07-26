//递归
package chapter12.heimaPro.demo02Recurison;

/*
 * 递归的分类；递归分为两种，直接递归和间接递归
 *      1、直接递归称为方法自身调用自己
 *      2、间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法
 * 注意事项：
 *      1、递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出
 *      2、在递归中虽然有限定条件，但是递归次数不能太多，否则也会发生栈内存溢出
 *      3、构造方法，禁止递归
 * 递归的使用前提：
 *      当调用方法的时候，方法的主体不变，每次调用方法的参数不同，可以使用递归
 * */
public class Demo01Recurison {
    public static void main(String[] args) {
//        a();      //StackOverflowError栈内存溢出异常
        b(1);
    }

    /*
     * 构造方法，禁止递归
     * 编译报错：构造方法是创建对象使用的，一直递归会导致内存中有无数多个对象，直接编译报错
     * */
    public Demo01Recurison() {
//        Demo07Recurison();      //报错Method call expected
    }

    /*
     * 递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出
     * java.lang.StackOverflowError栈内存溢出异常
     * */
    private static void a() {
        System.out.println("a方法");
        a();
    }

    /*
     * 在递归中虽然有限定条件，但是递归次数不能太多，否则也会发生栈内存溢出
     * */
    private static void b(int i) {
        System.out.println(i);
        if (i == 10000) {       //次数不能太多，太多会溢出
            return;     //结束方法
        }
        b(++i);
    }
}
