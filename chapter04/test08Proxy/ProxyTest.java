//4.8 代理
package chapter04.test08Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/* 代理：
 * 在运行时创建一个实现一组给定接口的新类。*/

/**
 * 使用代理对象对二分查找进行跟踪，首先将用1~1000整数代理填充数组，
 * 然后调用Arrays类中的binarySearch方法在数组中查找一个随机整数。最后打印出匹配的元素。
 * @author mly
 * */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        //用1~1000整数的代理填充数组
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            //创建接口对象
            InvocationHandler handler = new TraceHandler(value);
            //构造实现
            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }

        //创建一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;

        //二分查找
        int result = Arrays.binarySearch(elements, key);

        //如果找到了，打印出来
        if (result >= 0)
            System.out.println(elements[result]);
    }
}

/**
 * 调用处理器接口的实现类，打印方法名和参数，然后调用原始方法
 * */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * 构造器
     * @param t 方法调用的隐式参数
     * */
    public TraceHandler (Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        //打印隐式参数
        System.out.print(target);
        //打印方法名
        System.out.print("." + m.getName() + "(");
        //打印显式参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1)
                    System.out.print(", ");
            }
        }
        System.out.print(")");

        //调用实际的方法
        return m.invoke(target, args);
    }
}

