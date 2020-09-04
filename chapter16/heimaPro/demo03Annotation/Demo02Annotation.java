//JDK种预定义的一些注解
package chapter16.heimaPro.demo03Annotation;

/*
 * 常见的注解：
 * @Override：检测被该注解标注的方法是否是继承自父类(接口)的
 * @Deprecated：该注解标注的内容，已过时
 * @SuppressWarnings：压制警告，一般传递参数all
 *
 * 自定义注解：
 * 格式：public @interface 注解名称{}
 * 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
 * public interface 注解名称 extends java.lang.annotation.Annotation {}
 * 属性：接口中可以定义的成员方法
 *
 * */
@SuppressWarnings("all")
public class Demo02Annotation {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        //有缺陷
    }

    public void show2() {
        //替代show1
    }

    //自定义注解
    @MyAnno(age = 12, strs = {"aa", "bb"})
    @MyAnno2(15)        //如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
    public void demo() {

    }
}
