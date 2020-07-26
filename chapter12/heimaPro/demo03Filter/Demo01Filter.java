//FileFilter过滤器的原理和使用
package chapter12.heimaPro.demo03Filter;

import java.io.File;

/*
 * 练习：递归打印多级目录
 * 需求：
 *      遍历F:\Java\Project\Study\src\chapter12\\heimaPro文件夹的子文件夹
 *      只要.java结尾的文件
 * 可以使用过滤器来实现
 *
 * 在File类中有两个和listFiles重载的方法，方法的参数传递的就是过滤器
 * File[] listFiles(FileFilter filter)
 *
 * java.io.FileFilter接口：用于抽象路径名(File对象)的过滤器
 *      作用：用来过滤文件(File对象)
 *      抽象方法：用来过滤文件的方法
 *          boolean accept(File pathname)：测试指定抽象路径名是否应该包含在某个路径名列表中
 *      参数：
 *          File pathname：使用listFiles方法遍历目录，得到的每一个文件对象
 *
 * File[] listFiles(FilenameFilter filter)
 * java.io.FilenameFilter接口：实现此接口的类实例可用于过滤器文件名
 *      作用：用于过滤文件名称
 *      抽象方法：用来过滤文件名称的方法
 *          boolean accept(File dir, String name)：测试指定文件是否应该包含在某一文件列表中
 *      参数：
 *          File dir：构造方法中传递的被遍历的目录
 *          String name：使用ListFiles方法遍历目录，获取的每一个文件/文件夹的名称
 *
 * 注意：
 *      两个过滤器接口是没有实现类的，需要我们自己写实现类，重写过滤的方法accept，在方法中自己定义过滤的规则
 * */
public class Demo01Filter {
    public static void main(String[] args) {
        /*
         * listFiles方法一共做了3件事情：
         * 1、listFiles方法会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象
         * 2、listFiles方法会调用参数传递的过滤器中的方法accept
         * 3、listFiles方法会把遍历得到的每一个File对象，传递给accept方法的参数pathname
         *
         * 注意：accept的返回值为
         * 1、true：就会把传递过去的File对象保存到File数组中
         * 2、false：就不会把传递过去的File对象保存到File数组中
         *
         * 过滤的规则：
         * 在accept方法中，如果pathname是一个文件夹，返回true，继续遍历这个文件夹
         * 判断File对象是否以.java结尾，是返回true，否返回false
         * */
        File file = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro");
        getAllFile(file);
    }

    public static void getAllFile(File dir) {
        //传递过滤器
        File[] files = dir.listFiles(new FileFilterImpl());
        for (File f : files) {
            //对遍历得到的File对象f进行判断其是否为文件夹
            if (f.isDirectory()) {
                //直接调用自己，递归
                getAllFile(f);
            } else {        //f是一个文件
                    System.out.println(f);
            }
        }
    }
}
