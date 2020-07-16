//成员内部类
package chapter04.heima.demo06InnerClass;

//如果出现了重名现象，那么格式是，外部类名称.this.外部类成员变量名
public class Outer1 {

    int num = 10;       //外部类的成员变量

    public class Inner /*extends Object*/{
        //内部类的成员变量
        int num = 20;

        public void methodInner() {
            //内部类方法的局部变量
            int num = 30;
            System.out.println(num);        //30  局部变量
            System.out.println(this.num);   //20  内部类的成员变量
            //内部类和外部类不是继承关系，无法使用super调用外部类的成员变量
//            System.out.println(super.num);        //错误

            //如果出现了重名现象，那么格式是，外部类名称.this.外部类成员变量名
            System.out.println(Outer1.this.num);     //10 外部类的成员变量
        }
    }
}
