package chapter03.heima.demo03Test;

import java.util.ArrayList;

//群主的类
public class Manager extends User {
    public Manager() {

    }

    //调用父类的构造方法
    public Manager(String name, int money) {
        super(name, money);
    }

    /*
     * 发红包的逻辑：
     * 返回值类型： ArrayList<Integer>
     * 方法名称：   send
     * 参数列表：  1.总共发多少钱  int totalMoney
     *            2.分成多少份    int count
     * */
    public ArrayList<Integer> send(int totalMoney, int count) {
        //首先需要一个集合，用来存储若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主有多少钱
        int leftMoney = super.getMoney();       //群主当前余额
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;                     //返回空集合
        }

        //扣钱，重新设置余额
        super.setMoney(leftMoney - totalMoney);

        //发红包平均拆分成为count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;           //余数，零头

        //除不开的零头，包在最后一个红包中
        //下面把红包一个一个放到集合中
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }

        //最后一个红包，加一个零头
        int last = avg + mod;
        redList.add(last);

        return redList;
    }
}
