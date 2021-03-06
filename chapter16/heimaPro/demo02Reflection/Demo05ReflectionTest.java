//反射案例
package chapter16.heimaPro.demo02Reflection;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * 需求：写一个"框架"，可以创建任意类的对象，并且执行其中任意方法
 * 实现：
 * 1、配置文件
 * 2、反射
 *
 * 步骤：
 * 1、将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 2、在程序中加载读取配置文件
 * 3、使用反射技术来加载类文件进内存呢
 * 4、创建对象
 * 5、执行方法
 * */
public class Demo05ReflectionTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，并且执行其中任意方法

        //文件路径，如果出错会发生空指针异常
        String filename = "chapter16/heimaPro/demo02Reflection/pro.properties";

        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的一个配置文件
        ClassLoader classLoader = Demo05ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);

        //4.创建对象
        Object o = cls.newInstance();

        //5.获取方法对象
        Method method = cls.getMethod(methodName);

        //6.执行方法
        method.invoke(o);
    }
}
