//类作为成员变量类型
package chapter04.heima.demo08ClassType;

//游戏当中的英雄角色类
public class Hero {
    //类作为成员变量类型
    private String name;        //英雄名字
    private Weapon weapon;      //武器
    private int age;            //年龄

    public Hero() {
    }

    public Hero(String name, Weapon weapon, int age) {
        this.name = name;
        this.weapon = weapon;
        this.age = age;
    }

    public void attack() {
        //注意weapon是个类，要用get方法
        System.out.println("年龄为：" + age + "的" + name + "用" + weapon.getCode() + "攻击敌人。");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
