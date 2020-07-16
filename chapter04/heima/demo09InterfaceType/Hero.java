//接口作为成员变量类型
package chapter04.heima.demo09InterfaceType;

public class Hero {
    private String name;    //英雄的名称
    //接口作为成员变量类型
    private Skill skill;    //英雄的技能

    public Hero() {

    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void attack() {
        System.out.println("无敌的" + name + "使用了技能：");
        skill.use();    //调用接口中的抽象方法
        System.out.println("技能施放完成。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
