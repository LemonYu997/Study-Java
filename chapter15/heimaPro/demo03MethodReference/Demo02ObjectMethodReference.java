//通过对象名引用成员方法   Object::method
package chapter15.heimaPro.demo03MethodReference;

/*
 * 通过对象名引用成员方法
 * 使用前提是对象名是已经存在的，成员方法也是已经存在的，就可以使用对象名来以用成员方法
 * */
public class Demo02ObjectMethodReference {
    //定义一个方法，方法的参数是传递Printable接口
    public static void printString(Printable p) {
        p.print("Hello");
    }

    public static void main(String[] args) {
        //调用printString方法，方法的参数Printable是一个函数式接口，所以可以传递Lambda表达式
        printString((s)->{
            //创建MethodRerObject对象
            MetodRerObject obj = new MetodRerObject();
            //调用MethodRerObject对象中的成员方法printUpperCaseString，把字符串按照大写输出
            obj.printUpperCaseString(s);
        });

        /*
         * 使用方法引用优化Lambda
         * 对象是已经存在的MethodRerObject
         * 成员方法也是已经存在的printUpperCaseString
         * 所以可以使用对象名引用成员方法
         * */
        //创建MethodRerObject对象
        MetodRerObject obj = new MetodRerObject();
        printString(obj::printUpperCaseString);
    }
}
