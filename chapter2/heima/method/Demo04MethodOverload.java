//方法重载
package chapter2.heima.method;

/*
 * 对于功能类似的方法，因为参数不一样却要定义很多方法，很不方便，引入重载功能
 *
 * 方法的重载(overload)：多个方法的名称一样，但是参数列表不一样。
 * 好处：只需要记住唯一一个方法名称，就可以实现类似多个功能。
 *
 * 方法重载与下列因素相关：
 * 1、参数个数不同
 * 2、参数类型不同
 * 3、参数的多类型顺序不同
 *
 * 方法重载与下列因素无关：
 * 1、与参数的名称无关
 * 2、与方法的返回值类型无关
 * */

public class Demo04MethodOverload {
    public static void main(String[] args) {
        /*System.out.println(sumTwo(10, 20));                     //30
        System.out.println(sumThree(10, 20, 30));            //60
        System.out.println(sumFour(10, 20, 30, 40));      //100*/

        System.out.println(sum(10, 20));                    //30
        System.out.println(sum(10, 20, 30));             //60
        System.out.println(sum(10, 20, 30, 40));      //100
//        System.out.println(sum(10, 20, 30, 40, 50));        //报错，无匹配方法
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    /*//错误写法！与参数的名称无关
    public static int sum(int x, int y) {
        return x + y;
    }*/

    /*//错误写法！与方法的返回值类型无关
    public static double sum(int a, int b) {
        return a + b;
    }*/

    public static int sum(double a, double b) {
        return (int) (a + b);
    }



    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        return a + b +c + d;
    }
}
