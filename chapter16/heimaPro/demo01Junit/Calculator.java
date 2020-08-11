//Junit 单元测试
package chapter16.heimaPro.demo01Junit;

/*
 * 计算器类
 * */
public class Calculator {

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
//        int i = 1 / 0;
        return a + b;
//        return a - b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int sub(int a, int b) {
        return a - b;
    }
}
