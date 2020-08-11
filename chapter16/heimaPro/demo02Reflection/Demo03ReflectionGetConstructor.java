//Class对象的功能————获取成员变量
package chapter16.heimaPro.demo02Reflection;

import java.lang.reflect.Constructor;

/*
 * Class对象功能
 *
 * 获取的功能：
 * 1、获取成员变量们
 *    Field[] getFields()               获取所有public修饰的成员变量
 *    Field getField(String name)
 *    Field[] getDeclareFields()        获取所有的成员变量，不考虑修饰符
 *    Field getDeclareField(String name)
 * 2、获取构造方法们
 *    Constructor<?>[] getConstructors()
 *    Constructor<T> getConstructor(Class<?>...parameterTypes)
 *    Constructor<?>[] getDeclaredConstructors()
 *    Constructor<T> getDeclaredConstructor(Class<?>...parameterTypes)
 * 3、获取成员方法们
 *    Method[] getMethods()
 *    Method getMethod(String name, Class<?>...parameterTypes)
 *    Method[] getDeclaredMethods()
 *    Method getDeclaredMethod(String name, Class<?>...parameterTypes)
 * 4、获取类名
 *    String getName()
 *
 * constructor：构造方法
 * 创建对象：T newInstance(Object...initargs)
 *
 * 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 * */
public class Demo03ReflectionGetConstructor {

    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;
        /**
         * 2、获取构造方法们
         *    Constructor<?>[] getConstructors()
         *    Constructor<T> getConstructor(Class<?>...parameterTypes)
         *    Constructor<?>[] getDeclaredConstructors()
         *    Constructor<T> getDeclaredConstructor(Class<?>...parameterTypes)
         * */
        //Constructor<T> getConstructor(Class<?>...parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("苍蓝星", 20);
        System.out.println(person);
        System.out.println("------------------------------------------");

        //空参形式
//        Constructor constructor1 = personClass.getConstructor();
//        System.out.println(constructor1);
        //创建对象
        Object person1 = personClass.newInstance();
        System.out.println(person1);

    }
}
