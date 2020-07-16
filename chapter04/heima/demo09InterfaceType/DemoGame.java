//接口作为成员变量类型
package chapter04.heima.demo09InterfaceType;

public class DemoGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("苍蓝星");        //设置英雄的名称

        //设置英雄技能
//        hero.setSkill(new SkillImpl()); //使用单独定义的实现类

        //改成使用匿名内部类
//        Skill skill = new Skill() {
//            @Override
//            public void use() {
//                System.out.println("咸鱼突刺");
//            }
//        };
//        hero.setSkill(skill);

        //进一步简化，同时使用匿名内部类和匿名对象
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("龙击炮");
            }
        });

        hero.attack();
    }
}
