//Class对象的功能————获取成员变量
package chapter16.heimaPro.demo02Reflection;

import java.lang.reflect.Field;

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
 * Field：成员变量操作
 * 1、设置值
 *    set(Object obj, Object value)
 * 2、获取值
 *    get(Object obj)
 * 3、忽略访问权限修饰符的安全检查
 *    成员名.setAccessible(true);      //暴力反射
 * */
public class Demo02ReflectionGetField {

    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;
        /**
         * 1、获取成员变量们
         *    Field[] getFields()               获取所有public修饰的成员变量
         *    Field getField(String name)
         *    Field[] getDeclareFields()        获取所有的成员变量，不考虑修饰符
         *    Field getDeclareField(String name)
         * */
        //1.1   Field[] getFields()
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------------------------------------");

        //1.2   Field getField(String name)
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);        //参数是一个具体的对象
        System.out.println(value);      //null  默认值
        //设置a的值
        a.set(p, "苍蓝星");
        System.out.println(p);          //Person{name='null', age=0, a='苍蓝星', b='null', c='null', d='null'}
        System.out.println("------------------------------------------");

        //1.3   Field[] getDeclareFields()
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("------------------------------------------");

        //1.4   Field getDeclareField(String name)
        Field d = personClass.getDeclaredField("d");
        //获取private修饰的成员变量，忽略访问权限修饰符的安全检查
        d.setAccessible(true);      //暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
