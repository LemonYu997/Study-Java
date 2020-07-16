package chapter04.heima.demo10Test;

import chapter04.heima.demo10Test.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount;      //平均值
        int mod = totalMoney % totalCount;      //余数，零头

        //除了最后一个红包，剩下的平均分配
        //totalCount - 1代表最后一个先留着
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        //零头放在最后一个红包中
        list.add(avg + mod);

        return list;
    }
}
