//测试创建的泛型类
package chapter06.heimaPro.demo01Generic;

public class Demo02GenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass gc1 = new GenericClass();
        gc1.setName("ABC");
        Object obj = gc1.getName();
        System.out.println(obj);

        //创建一个GenericClass对象，泛型使用Integer类型
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(23);
        Integer name = gc2.getName();
        System.out.println(name);

        //创建一个GenericClass对象，泛型使用String类型
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("DDDD");
        String s = gc3.getName();
        System.out.println(s);
    }
}
