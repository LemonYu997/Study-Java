package chapter04.heima.demo06InnerClass;

public class Demo02InnerClass {
    public static void main(String[] args) {
        //使用成员内部类
        //外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
        Outer1.Inner obj = new Outer1().new Inner();
        obj.methodInner();
    }
}
