package chapter02.heima.demo01Object;

/*
 * 对于基本类型当中的boolean值，Getter方法一定要写成isXxx的形式，而setXxx规则不变
 * */

public class Person {
    String name;                //姓名
    private int age;            //年龄
    private boolean male;       //性别，是否为男

    public void show() {
        System.out.println("我叫：" + name + ", 年龄：" + age);
    }

    //设置age数据
    public void setAge(int num) {
        //合理情况
        if (num < 100 && num >= 0) {
            age = num;
        } else {
            System.out.println("数据不合理");
        }
    }

    //获取age数据
    public int getAge() {
        return age;
    }

    public void setMale(boolean is) {
        male = is;
    }

    public boolean isMale() {
        return male;
    }


}
