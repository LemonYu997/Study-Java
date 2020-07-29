//对象的反序列化流 ObjectInputStream
package chapter12.heimaPro.demo10Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * java.io.ObjectInputStream
 * ObjectInputStream：对象的反序列化流
 * 作用：把文件中保存的对象，以流的方式读取出来使用
 *
 * 构造方法：
 * public ObjectInputStream(InputStream in) throws IOException创建从指定 InputStream 读取的 ObjectInputStream
 * 参数：
 *      InputStream in：字节输入流
 *
 * 特有的成员方法：
 * public final Object readObject() throws IOException, ClassNotFoundException 读取对象
 *
 * 使用步骤：
 * 1、创建ObjectInputStream对象，构造方法中传递字节输入流
 * 2、使用ObjectInputStream对象中的方法readObject读取保存对象的文件
 * 3、释放资源
 * 4、使用读取出来的对象(打印)
 *
 * readObject方法声明抛出了ClassNotFoundException(class文件找不到异常)
 * 当不存在对象的class文件时抛出异常
 * 反序列化的前提：
 * 1、类必须实现Serializable
 * 2、必须存在类对应的class文件
 *
 * static关键字：静态关键字
 *      静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
 *      被static修饰的成员变量不能被序列化的，序列化的都是对象
 *      private static int age
 *      oos.writeObject(new Person("苍蓝星", 18));
 *      Object o = ois.readObject();
 *      Person{name='苍蓝星', age=0}
 *
 * transient关键字：瞬态关键字
 *      被transient修饰的成员变量，不能被序列化
 *      private static int age
 *      oos.writeObject(new Person("苍蓝星", 18));
 *      Object o = ois.readObject();
 *      Person{name='苍蓝星', age=0}
 *
 * 【注意】当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，
 * 那么反序列化操作也会失败，抛出一个InvalidClassException异常，原因如下：
 * 1、该类的序列版本号与从流中读取的类描述符的版本号不匹配
 * 2、该类包含未知数据类型
 * 3、该类没有可访问的无参数构造方法
 *
 * java.io.InvalidClassException: chapter12.heimaPro.demo10Serialization.Person;
 * local class incompatible: stream classdesc serialVersionUID = 9132782084063805978, local class serialVersionUID = 7249953061945078926
 *
 * 解决方法：手动添加序列号
 * 序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联，该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。
 * 如果接收者加载的该对象的类的 serialVersionUID 与对应的发送者的类的版本号不同，则反序列化将会导致 InvalidClassException。
 * 可序列化类可以通过声明名为 "serialVersionUID" 的字段（该字段必须是静态 (static)、最终 (final) 的 long 型字段）显式声明其自己的 serialVersionUID：
 * ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L
 * */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、创建ObjectInputStream对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo10Serialization\\person.txt"));
        //2、使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        Object o = ois.readObject();
        //3、释放资源
        ois.close();
        //4、使用读取出来的对象(打印)
        System.out.println(o);
        Person p = (Person) o;
        System.out.println(p.getName() + p.getAge());
    }
}
