//3.6 反射
package chapter3.reflection;

import sun.java2d.pipe.SpanIterator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/* 反射机制的作用：
 * 1、在运行时分析类的能力
 * 2、在运行时查看对象，例如编写一个toString方法提供所有类使用
 * 3、实现通用的数组操作代码
 * 4、利用Method对象，这个对象很像C++中的函数指针                 */

//输入类名，会输出类中所有的方法和构造器的签名以及全部域名
//示例输入：java.lang.Double
public class ReflectionTest {
    public static void main(String[] args) {
        //从命令行参数或者用户输入中读取类名
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        //捕获异常
         try {
             //输入类名和超类名 (if != Object)
             Class cl = Class.forName(name);                                //返回描述类名为name的Class对象
             Class superc1 = cl.getSuperclass();
             String modifiers = Modifier.toString(cl.getModifiers());
             if (modifiers.length() > 0)
                 System.out.print(modifiers + " ");
             System.out.print("class " + name);
             if (superc1 != null && superc1 != Object.class)
                 System.out.print(" extends " + superc1.getName());

             System.out.print("\n{\n");
             printConstructors(cl);
             System.out.println();
             printMethods(cl);
             System.out.println();
             printFields(cl);
             System.out.println("}");

         }
         catch (ClassNotFoundException e)
         {
            e.printStackTrace();
         }
         System.exit(0);

    }
}

public static void printConstructors(Class cl)
{
    Constructor[] constructors = cl.getDeclaredConstructors();

    for (Constructor c : constructors)
    {
        String name = c.getName();
        System.out.print("  ");
        String modifiers = Modifier.toString(c.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");
        System.out.print(name + "(");

        //
        Class[] paramTypes = c.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++)
        {
            if (j > 0)
                System.out.print(", ");
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }
}

public static void printMethods(Class cl)
{
    Method[] methods = cl.getDeclaredMethods();

    for (Method m: methods)
    {
        Class retType = m.getReturnType();
        String name = m.getName();

        System.out.print("  ");
        String modifiers = Modifier.toString(m.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");
        System.out.print(retType.getName() + " " + name + "(");

        Class[] paramTypes = m.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++)
        {
            if (j > 0)
                System.out.print(", ");
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }
}

public static void printFields(Class cl)
{
    Field[] fields = cl.getDeclaredFields();

    for (Field f : fields)
    {
        Class type = f.getType();
        String name = f.getName();
        System.out.print("  ");
        String modifiers = Modifier.toString(f.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");
        System.out.println(type.getName() + " " + name + ";");
    }
}


