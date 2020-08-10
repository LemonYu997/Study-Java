//方法引用
package chapter15.heimaPro.demo03MethodReference;

/*
 * Lambda表达式：(s)->{System.out.println(s);}
 * 方法引用：printString(System.out::println);
 * :: 为引用运算符，它所在的表达式被称为方法引用。
 * 如果Lambda要表达的函数方案已经存在于某个方法的实现中，那么则可以通过双冒号引用该方法作为Lambda的替代者
 *
 * 注意：
 * Lambda中传递的参数一定是方法引用中那个方法可以接收的类型，否则会抛出异常
 * */
public class Demo01Printable {
    //定义一个方法，参数传递Printable接口，对字符串进行打印
    public static void printString(Printable p) {
        p.print("HelloWorld");
    }

    public static void main(String[] args) {
        //调用printString方法，方法的参数Printable是一个函数式接口，所以可以传递Lambda
        printString((s)->{
            System.out.println(s);
        });

        /*
         * 分析：
         * Lambda表达式的目的，打印参数传递的字符串
         * 把参数s传递给了System.out对象，调用out对象中的方法println对字符串进行了输出
         * 注意：
         * 1、System.out对象是已经存在的
         * 2、println方法也是已经存在的
         * 所以可以使用方法引用来优化Lambda表达式
         * 可以使用System.out方法直接引用(调用)println方法
         * */
        printString(System.out::println);
    }
}
