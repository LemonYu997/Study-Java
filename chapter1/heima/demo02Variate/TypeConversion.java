//黑马 类型转换
package chapter1.heima.demo02Variate;

/*
 * 类型转换：
 * 当数据类型不一样时，就会发生数据类型转换
 *
 * 自动类型转换(隐式)：
 * 1、特点：代码不需要进行特殊处理，自动完成
 * 2、规则：数据范围从小到大(是数据范围，不是字节数！！！)
 *
 * 强制类型转换(显式)：
 * 1、特点：代码需要进行特殊的格式处理，不能自动完成
 * 2、格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
 *
 * 注意事项：
 * 1、强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出
 * 2、byte/short/char这三种类型都可以发生数学运算，例如加法"+"
 * 3、byte/short/char这三种类型在运算的时候，都会首先提升为int类型，然后再计算
 * 4、boolean类型不能发生数据类型转换
 *
 * 备注：
 * 在给变量进行赋值的时候，如果右侧的表达式当中全部都是常量，没有任何变量，那么编译器javac将会直接将若干个常量表达式计算得到结果。
 * short result = 5 + 8;            //等号右边全是常量，没有任何变量参与运算
 * 编译之后，得到的.class字节码文件当中相当于是：
 * short result = 13;               //右侧的常量结果数值，没有超过左侧范围，所以正确
 *
 * 称为”编译器的常量优化“
 * 但是一旦表达式中有变量参与，就不能进行这种优化了。
 * */

public class TypeConversion {
    public static void main(String[] args) {
        System.out.println(1024);       //整数，默认int类型
        System.out.println(3.14);       //浮点数，默认double类型

        //左边是long类型，右边是默认的int类型，左右不一样
        //一个等号代表赋值，将右侧的int常量，交给左侧的long变量进行存储
        //int-->long，符合了数据范围从小到大的要求
        //这一行代码发生了自动类型转换
        long num1 = 100;
        System.out.println(num1);       //100

        //左边是double类型，右边是float类型，左右不一样
        //float-->double，符合从小到大的规则
        //也发生了自动类型转换
        double num2 = 2.5F;
        System.out.println(num2);       //2.5

        //左边是float类型，右边是long类型，左右不一样
        //long-->float，范围是float更大，符合从小到大
        //是数据范围！！！不是字节数！！！！
        //也发生了自动类型转换
        float num3 = 30L;
        System.out.println(num3);       //30.0

        System.out.println("-------------------------------------------");

        //左边是int类型，右边是long类型，不一样
        //long-->int，不是从小到大
        //不能发生自动类型转换！
        //格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
        int num4 = (int)100L;
        System.out.println(num4);


        //long强制转换成int类型，发生数据溢出
        int num5 = (int)6000000000L;
        System.out.println(num5);       //1705032704


        //double --> int，强制类型转换
        //精度损失，不是四舍五入，是直接丢弃
        int num6 = (int)3.99;
        System.out.println(num6);       //3

        //byte/short/char这三种类型都可以发生数学运算，例如加法"+"
        char zifu1 = 'A';               //这是一个字符型变量，内容是A
        System.out.println(zifu1 + 1);  //66，即A被当作65进行处理
        //计算机的底层会用一个数字(二进制)来代表字符A，就是65

        byte num7 = 40;                 //注意：右侧数值大小不能超过左侧的类型范围
        byte num8 = 50;
        //byte类型进行运算时会提升为int类型
        //byte + byte --> int + int --> int
//      byte result1 = num7 + num8;   //报错
        int result1 = num7 + num8;
        System.out.println(result1);    //90

        short num9 = 60;
        //byte + short --> int + int --> int
        //int强制转换为short，必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
        short result2 = (short)(num9 + num7);
        System.out.println(result2);    //100


        //右侧不用变量，而采用常量，而且只有两个常量
        short result3 = 5 + 8;
        System.out.println(result3);
    }
}
