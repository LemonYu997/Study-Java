//反射案例，使用注解代替配置文件
package chapter16.heimaPro.demo03Annotation;

import java.lang.reflect.Method;

/*
 * 需求：写一个"框架"，可以创建任意类的对象，并且执行其中任意方法
 * 实现：
 * 1、注解
 * 2、反射
 *
 * 步骤：
 * 1.解析注解
 * 2.获取上边的注解文件
 * 3.调用注解对象中定义的抽象方法，获取返回值
 * 4.使用反射技术来加载类文件进内存呢
 * 5.创建对象
 * 6.获取方法对象
 * 7.执行方法
 *
 * 在程序使用(解析)注解：获取注解中定义的属性值
 * 1、获取注解定义的位置的对象(Class, Method, Field)
 * 2、获取指定的注解：
 *  getAnnotation(Class)
 * 3、调用注解中的抽象方法获取配置的属性值
 * */
@Pro(className = "chapter16.heimaPro.demo03Annotation.Worker", methodName = "show")
public class Demo03ReflectionTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，并且执行其中任意方法

        //1.解析注解
        //1.1获取该类字节码文件对象
        Class<Demo03ReflectionTest> reflectionTestClass = Demo03ReflectionTest.class;
        //2.获取上边的注解文件
        //其实就是在内存中生成一个该注解的接口的子类实现对象
        Pro an = reflectionTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        //4.加载该类进内存
        Class cls = Class.forName(className);

        //5.创建对象
        Object o = cls.newInstance();

        //6.获取方法对象
        Method method = cls.getMethod(methodName);

        //7.执行方法
        method.invoke(o);
    }
}

/*
public class ProImpl implements Pro {
    @Override
    public String className() {
        return "chapter16.heimaPro.demo03Annotation.Worker";
    }

    @Override
    public String methodName() {
        return "show";
    }
}
*/
