//发红包案例
package chapter04.heima.demo10Test;

import chapter04.heima.demo10Test.red.OpenMode;

/*
 * 场景说明：红包发出去后，所有人都抢，抢完之后，最后一个给群主
 *
 * 大多数代码都是线程的，我们需要做的就是填空题
 *
 * 要做的事情：
 *      1、设置程序标题
 *      2、设置群主名称
 *      3、设置分发策略：平均，还是随机？
 *
 * 红包分发的策略：
 *      1、普通红包(平均)：totalMoney / totalCount，余数放在最后一个红包当中
 *      2、手气红包(随机)：最少1分钱，最多不超过平均数的2倍，应该是越发越少
 * */
public class Bootstrap {
    public static void main(String[] args) {
        MyRed red = new MyRed("我的红包");

        //设置群主名称
        red.setOwnerName("老板");

        //普通红包
        OpenMode normal = new NormalMode();
        red.setOpenWay(normal);

        //随机红包
        OpenMode random = new RandomMode();
        red.setOpenWay(random);
    }
}
