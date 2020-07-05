//3.6 反射part1 利用反射分析类的能力
package chapter3.test06Reflection;

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

/**
 * 这个程序利用反射来打印类的所有特性
 * @author mly
 */
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
             //输出类名和超类名 (if != Object)
             Class  cl = Class.forName(name);                                //返回描述类名为name的Class对象
             Class superCl = cl.getSuperclass();
             String modifiers = Modifier.toString(cl.getModifiers());        //返回类的修饰符，如：public/private/static/final等等
             if (modifiers.length() > 0)
                 System.out.print(modifiers + " ");
             System.out.print("class " + name);
             //如果存在超类并且这个超类不为Object，就输出extends + 超类名字
             if (superCl != null && superCl != Object.class)
                 System.out.print(" extends " + superCl.getName());

             System.out.print("\n{\n");
             printConstructors(cl);
             System.out.println();
             printMethods(cl);
             System.out.println();
             printFields(cl);
             System.out.println("}");

         }
         //如果类名不存在
         catch (ClassNotFoundException e)
         {
             //利用Throwable类中的printStackTrace方法打印出栈的轨迹
             e.printStackTrace();
         }
         //退出值为0，表示正常退出程序
         System.exit(0);
    }

    /**
     * 打印类的所有构造器
     * @param cl 一个类
     * */
    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();      //返回所有构造器

        //对每个构造器进行如下操作
        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());     //返回修饰符
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //输出参数类型
            Class[] paramTypes = c.getParameterTypes();                 //返回一个用于描述参数类型的对象数组
            for (int j = 0; j < paramTypes.length; j++)
            {
                //有多个参数时，用 , 隔开
                if (j > 0)
                    System.out.print(", ");
                //输出参数名
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的所有方法
     * @param cl 一个类
     * */
    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();                     //返回类的所有方法

        //对每个方法进行如下操作
        for (Method m: methods)
        {
            Class retType = m.getReturnType();                          //得到返回类型
            String name = m.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());     //返回修饰符
            //修饰符 返回类型 方法名 (参数1， 参数2 ... );
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

    /**
     * 打印类的所有域（属性）
     * @param cl
     * */
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();                        //返回类的所有域

        //对每个域进行操作
        for (Field f : fields)
        {
            //输出格式：修饰符 类型 名字;
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}

