//lambda表达式 有参数有返回值练习
package chapter11.heimaPro.demo10Lambda.test3;

/*
 * lambda表达式有参数有返回值的练习
 * 需求：
 *      给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
 *      使用Lambda的标准格式调用invokeCalc方法，完成120和130的相加计算
 * */
public class Demo01Calculator {
    public static void main(String[] args) {
        //调用invokeCalc方法，方法的参数是一个接口，可以使用匿名内部类
        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        //使用lambda表达式简化匿名内部类的缩写
        invokeCalc(120, 130, (int a, int b)->{
            return a + b;
        });
    }

    /*
     * 定义一个方法
     * 参数传递两个int类型的整数，Calculator接口
     * 方法内部调用Calculator中的方法计算两个整数的和
     */
    public static void invokeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }

}
