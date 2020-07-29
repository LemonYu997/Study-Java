//对象的序列化流 ObjectOutputStream
package chapter12.heimaPro.demo10Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * java.io.ObjectOutputStream extends OutputStream
 * ObjectOutputStream：对象的序列化流
 * 作用：把对象以流的方式写入到文件中保存
 *
 * 构造方法：
 * public ObjectOutputStream(OutputStream out) throws IOException 创建写入指定 OutputStream 的 ObjectOutputStream
 * 参数：
 *      OutputStream out：字节输出流
 *
 * 特有的成员方法：
 * public final void writeObject(Object obj) throws IOException 将指定的对象写入 ObjectOutputStream
 *
 * 使用步骤：
 * 1、创建ObjectOutputStream对象，构造方法中传递字节输出流
 * 2、使用ObjectOutputStream对象中的方法writeObject，把对象写入文件中
 * 3、释放资源
 *
 * java.io.NotSerializableException 当实例需要具有序列化接口时，抛出此异常，序列化运行时或实例的类会抛出此异常
 *
 * 类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化
 * Serializable接口也叫标记型接口，要进行序列化和反序列化的累必须实现Serializable接口，就会给类添加一个标记
 * 当进行序列化和反序列化的时候，就会检测类上是否有这个标记
 *      有：就可以序列化和反序列化
 *      没有：就会抛出NotSerializableException异常
 * */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        //1、创建ObjectOutputStream对象，构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo10Serialization\\person.txt"));
        //2、使用ObjectOutputStream对象中的方法writeObject，把对象写入文件中
        oos.writeObject(new Person("苍蓝星", 18));
        //3、释放资源
        oos.close();
    }
}
