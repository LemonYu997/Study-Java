//Junit 单元测试
package chapter16.heimaPro.demo01Junit;

/*
 * 测试分类：
 * 1、黑盒测试：不需要写代码，给输入值，看程序是否输出期望的值
 * 2、白盒测试：不需要写代码，关注程序的执行流程
 * Junit使用白盒测试
 *
 * 使用步骤：
 * 1、定义一个测试类
 *    建议：测试类名：被测试的类名Test   CalculatorTest
 *         包名：xxx.xxx.xx.test
 * 2、定义测试方法：可以独立运行
 *    建议：方法名：test测试方法名      testAdd()
 *         返回值：void
 *         参数列表：空参
 * 3、给方法加@Test注解
 * 4、导入Junit依赖环境
 *
 * 判定结果：
 * 红色：失败
 * 绿色：成功
 * 一般使用断言操作处理结果
 * Assert.assertEquals(期望的结果, 运算的结果);
 * */
public class Demo01CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();
        //调用
//        int result = c.add(1, 2);
        int result = c.sub(1, 1);
        System.out.println(result);

    }
}
