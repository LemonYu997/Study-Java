//黑马 变量
package chapter1.heima.demo02Variate;

/*
 * 变量：程序运行期间，内容可以发生改变的量。
 *
 * 创建一个变量并且使用的格式：
 * 数据类型 变量名称;               //创建一个变量
 * 变量名称 = 数据值;              //赋值，将右边的数据值，赋值交给左边的变量
 * 数据类型 变量名称 = 数据值;     //创建变量同时放入指定数据值
 *
 * 注意事项：
 * 1、创建多个变量，那么变量之间的名称不可以重复
 * 2、对于float和long类型来说，字母后缀F和L不要丢掉
 * 3、如果使用byte和short类型的变量，那么右侧的数据值不能超过左侧类型的范围
 * 4、没有进行赋值的变量，不能直接使用：一定要赋值之后，才能使用
 * 5、变量使用不能超过作用域的范围
 *    【作用域】：从定义变量的一行开始，一直到直接所属的大括号结束为止
 * */

public class VariateTest {
    public static void main(String[] args) {
        //创建一个变量
        int num1 = 10;
        System.out.println(num1);

        //改变变量当中本来的数字，变成新的数字
        num1 = 20;
        System.out.println(num1);       //20

        System.out.println("------------------------------");

        byte num2 = 30;         //注意：右侧数值的范围不能超过左侧数据类型的取值范围
        System.out.println(num2);       //30

//        byte num3 = 400;
//        System.out.println(num3);

        short num3 = 50;
        System.out.println(num3);       //50

        long num4 = 300000000000000L;
        System.out.println(num4);       //300000000000000

        float num5 = 2.5F;
        System.out.println(num5);       //2.5

        double num6 = 1.2;
        System.out.println(num6);       //1.2

        char zifu1 = 'A';
        System.out.println(zifu1);      //A

        zifu1 = '中';
        System.out.println(zifu1);      //中

        boolean var1 = true;
        System.out.println(var1);       //true

        var1 = false;
        System.out.println(var1);       //false

        //将一个变量的数据内容，赋值交给另一个变量
        //右侧的变量名称var1已经存在，里面装的是false布尔值
        //将右侧变量里面的false值，向左交给var2变量进行存储
        boolean var2 = var1;
        System.out.println(var2);
    }
}
