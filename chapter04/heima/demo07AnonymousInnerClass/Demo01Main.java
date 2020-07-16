package chapter04.heima.demo07AnonymousInnerClass;

/*
 * 如果接口的实现类(或者是父类的子类)只需要使用唯一的一次
 * 那么这种情况下就可以直接省略掉该类的定义，而改为使用【匿名内部类】
 *
 * 匿名内部类的定义格式：
 * 接口名称 对象名 = new 接口名称() {
 *      //覆盖重写所有抽象方法
 * };       //注意这个【分号】
 *
 * 对格式"new 接口名称() {...}"进行解析：
 * 1、new代表创建对象的动作
 * 2、接口名称就是匿名内部类需要实现哪个接口
 * 3、{...}这才是匿名内部类的内容
 *
 * 另外还要注意几个问题：
 * 1、匿名内部类，在【创建对象】的时候，只能使用唯一一次
 *    如果希望多次创建对象，而且类的内容一样，那么就必须使用单独定义的实现类
 * 2、匿名对象，在【调用方法】的时候，只能调用唯一一次
 *    如果希望同一个对象，调用多次方法，那么必须给对象起个名字。
 * 3、匿名内部类是省略了【实现类/子类名称】，但是【匿名对象】是省略了【对象名称】
 * 强调：匿名内部类和匿名对象不是一回事！！！
 * */
public class Demo01Main {
    public static void main(String[] args) {
        //实现接口
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method1();

        //多态，左边接口，右边实现类
        MyInterface obj = new MyInterfaceImpl();
        obj.method1();

//        MyInterface some = new MyInterface();   //错误写法！

        //使用匿名内部类，但不是匿名对象，对象名称就叫objA
        //接口名称 对象名 = new 接口名称() {...};
        MyInterface objA = new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法! 111-A");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法! 222-A");
            }
        };
        objA.method1();
        objA.method2();
        System.out.println("-------------------------------");

        //想要再创建一个对象，就要再重写一次
        //使用匿名内部类，而且省略了对象名称，也是匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-B");
            }
        }.method1();
        //因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类的匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-B");
            }
        }.method2();
    }
}
