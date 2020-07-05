//3.7 反射part2 在运行时用反射分析对象
package chapter3.test07ObjectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 将对象转换为列出所有域的字符串表示形式
     * @param obj 一个对象
     * @返回一个字符串，包含对象的类名、域名和值
     * */
    public String toString(Object obj)
    {
        //如果对象为空
        if (obj == null)
            return "null";
        //如果对象相同，输出...
        if (visited.contains(obj))
            return "...";
        //添加元素
        visited.add(obj);
        Class cl = obj.getClass();
        //如果是String类，直接输出
        if (cl == String.class)
            return (String) obj;
        //如果是数组
        if (cl.isArray())
        {
            String r = cl.getComponentType() + "[]{";       //返回数组中元素的Class对象，如果不是Class对象那么返回null
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    r += ",";
                Object val = Array.get(obj, i);             //返回一个对象，其值为obj中域的当前值
                if (cl.getComponentType().isPrimitive())    //判断其是否为基本数据类型
                    r += val;
                else
                    r += toString(val);                     //否则用字符串形式打印
            }
            return r + "}";
        }

        String r = cl.getName();                            //得到类名
        //检查cl类的域和超类
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            //将此对象的 accessible 标志设置为指示的布尔值。值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
            //值为 false 则指示反射的对象应该实施 Java 语言访问检查。
            AccessibleObject.setAccessible(fields, true);
            //得到域的名字和值
            for (Field f : fields) {
                //修饰符不能是static
                if (!Modifier.isStatic(f.getModifiers()))
                {
                    //如果后缀不为 [
                    if (!r.endsWith("["))
                        r += ",";
                    r += f.getName() + "=";
                    //捕获异常
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive())
                            r += val;
                        else
                            r += toString(val);
                    }catch (Exception e)
                    {
                        e.printStackTrace();;
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
