package chapter03.heima.demo03Test;

import java.util.ArrayList;
import java.util.Random;

//群员的类
public class Member extends User {
    public Member() {

    }

    public Member(String name, int money) {
        super(name, money);
    }

    /*
     * 收红包的逻辑
     * 返回值类型： void
     * 方法名称：   receive
     * 参数列表：   ArrayList<Integer>
     * */
    public void receive(ArrayList<Integer> list) {
        //从多个红包当中随便抽取一个，给我自己
        //随机获取一个集合当中的索引编号
        int index = new Random().nextInt(list.size());
        //根据索引，从集合当中删除，并且得到被删除的红包
        Integer delta = list.remove(index);
        //当前成员本来有多少钱
        int money = super.getMoney();
        //加法，并且重新设置回去
        super.setMoney(money + delta);
    }
}
