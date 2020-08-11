//Junit单元测试
package chapter16.heimaPro.demo01Junit.test;

import chapter16.heimaPro.demo01Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* 使用步骤：
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
 *
 * 补充：
 * @Before：修饰的方法会在测试方法之前被自动执行
 * @After：修饰的方法会在测试方法执行之后自动被执行
 * */
public class CalculatorTest {

    /**
     * 初始化方法：
     * 用于资源的申请，所有测试方法在执行之前都会执行该方法
     * */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源方法：
     * 在所有测试方法执行完后，都会自动执行该方法
     * */
    @After
    public void close() {
        System.out.println("close...");
    }

    /**
     * 测试add方法
     * */
    @Test
    public void testAdd() {
//        System.out.println("执行了");
        System.out.println("testAdd...");
        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、调用add方法
        int result = c.add(1, 2);
//        System.out.println(result);
        //3、断言  这个结果是3
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        System.out.println("testSub...");
        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、调用sub方法
        int result = c.sub(1, 2);
        //3、断言  这个结果是-1
        Assert.assertEquals(-1, result);
    }
}
