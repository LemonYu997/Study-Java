//通过super引用父类的成员方法 super::method
package chapter15.heimaPro.demo03MethodReference;

//定义子类
public class Demo04SuperMethodReference extends Human{
    //子类重写父类sayHello方法
    @Override
    public void sayHello() {
        System.out.println("Hello 我是Man");
    }

    //定义一个方法，参数传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show(){
        //调用method方法，方法的参数Greetable是一个函数式接口，所以可以传递Lambda
        method(()->{
            //创建父类Human对象
            Human h = new Human();
            //调用父类的sayHello方法
            h.sayHello();
        });

        //因为有子父类关系，所以存在一个关键字super，可以直接使用super调用父类的成员方法
        method(()->{
            super.sayHello();
        });

        /*
         * 使用super引用父类的成员方法
         * super已经存在
         * 父类的成员方法sayHello也是已经存在的
         * 所以可以直接使用super引用父类的成员方法
         * */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        //匿名对象
        new Demo04SuperMethodReference().show();
    }
}
