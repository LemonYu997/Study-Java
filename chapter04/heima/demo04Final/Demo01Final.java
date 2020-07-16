//final关键字概念与4种用法
package chapter04.heima.demo04Final;

/*
 * final关键字代表最终、不可改变的
 *
 * 常见四种用法：
 * 1、可以用来修饰一个类
 * 2、可以用来修饰一个方法
 * 3、可以用来修饰一个局部变量
 * 4、还可以用来修饰一个成员变量
 * */
public class Demo01Final {
    //final关键字修饰一个局部变量
    public static void main(String[] args) {
        int num1 = 10;
        System.out.println(num1);       //10
        num1 = 20;
        System.out.println(num1);       //20

        //一旦使用final用来修饰局部变量，那么这个变量就不能进行更改
        //"一次赋值，终生不变"
        final int num2 = 200;
        System.out.println(num2);       //200

//        num2 = 250;       //错误写法！不能改变
//        num2 = 200;       //错误写法！不能再次赋值

        //正确写法！只要保证有一次赋值即可
        final int num3;
        num3 = 30;
        System.out.println("---------------------");

        //对于基本类型来说，不可变说的是变量当中的数据不可改变
        //对于引用类型来说，不可变说的是变量当中的地址值不可改变
        Student stu1 = new Student("Jack");
        System.out.println(stu1);               //@1b6d3586 地址值
        System.out.println(stu1.getName());     //Jack
        stu1 = new Student("Tom");
        System.out.println(stu1);               //@4554617c 地址值
        System.out.println(stu1.getName());     //Tom
        System.out.println("---------------------");

        final Student stu2 = new Student("Jerry");
        System.out.println(stu2.getName());     //Jerry
        //错误写法！final的引用类型，其中的地址不可改变
//        stu2 = new Student("Mercy");
        stu2.setName("Mercy");
        //地址值不能变，但是内容能变
        System.out.println(stu2.getName());     //Mercy
    }
}
