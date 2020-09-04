//Class对象的功能————获取成员变量
package chapter16.heimaPro.demo02Reflection;

import java.lang.reflect.Method;

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
 * Method：方法对象
 * 执行方法：Object invoke(Object obj, Object... args)
 *
 * 获取方法的名称：
 * String getName：获取方法名
 * */
public class Demo04ReflectionGetMethod {
    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;
        /**
         * 3、获取成员方法们
         *    Method[] getMethods()
         *    Method getMethod(String name, Class<?>...parameterTypes)
         *    Method[] getDeclaredMethods()
         *    Method getDeclaredMethod(String name, Class<?>...parameterTypes)
         * */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);
        System.out.println("---------------------");

        Method eat_method2 = personClass.getMethod("eat", String.class);
        //执行方法
        eat_method2.invoke(p, "饭");
        System.out.println("---------------------");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法名
            String name = method.getName();
            System.out.println(name);
//            method.setAccessible(true);
        }
        System.out.println("---------------------");

        /**
         * 4、获取类名
         *    String getName()
         * */
        String className = personClass.getName();
        System.out.println(className);
    }
}
