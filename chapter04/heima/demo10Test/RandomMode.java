package chapter04.heima.demo10Test;

import chapter04.heima.demo10Test.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        //随机分配，有可能多，有可能少
        //最少1分钱，最多不超过"剩下金额平均数的2倍"，以10元、3人为例
        //第一次发红包，随即范围是0.01元~6.66元
        //第一次发完之后，剩下的至少是3.34元
        //此时还要再发2个红包
        //此时再发范围应该是0.01~3.34元(取不到右边，剩下0.01)

        //总结一下，范围的【公式】：1 + random.nextInt(leftMoney / leftCount * 2)
        Random r = new Random();        //首先创建一个随机数生成器
        //totalMoney是总金额，totalCount是总份数，不变
        int leftMoney = totalMoney;     //剩下多少钱
        int leftCount = totalCount;     //剩下多少份

        //随机发前n-1个，最后一个不需要随机
        for (int i = 0; i < totalCount - 1; i++) {
            //按照公式生成随机金额
            int money = r.nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);            //将一个随机红包放入集合
            leftMoney -= money;         //剩下的金额越发越少
            leftCount--;                //剩下还应该再发的红包个数，递减
        }

        //最后一个红包不需要随机，直接放进去
        list.add(leftMoney);

        return list;
    }
}
