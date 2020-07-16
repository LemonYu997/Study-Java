//final修饰一个成员变量
package chapter04.heima.demo04Final;

/*
 * 对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变
 *
 * 1、由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值
 * 2、对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值，二者选其一
 * 3、必须保证类当中所有重载的构造方法，都最终会对final的成员变量进行赋值
 * */
public class Person {

//    private final String name;      //错误！必须要手动赋值

    //直接赋值后，之后的方法种的赋值语句会报错
//    private final String name = "Jack";

    //通过构造进行赋值
    private final String name;

    public Person() {
        name = "Jack";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
