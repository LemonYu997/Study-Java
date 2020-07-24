//File类
package chapter12.heimaPro.demo01File;

import java.io.File;

/*
 * java.lang.File类 文件和目录路径名的抽象表示形式
 * java把电脑中的文件和文件夹(目录)封装为了一个File类，可以使用File类对文件夹和文件进行操作
 *
 * File类的方法：
 *      创建一个文件/文件夹
 *      删除文件/文件夹
 *      获取文件/文件夹
 *      判断文件/文件夹是否存在
 *      对文件夹进行遍历
 *      获取文件的大小
 *
 * File类是一个与系统无关的类，任何操作系统都可以使用这个类中的方法
 *
 * 【重点】三个单词：
 *      file：文件
 *      directory：文件夹/目录
 *      path：路径
 *
 * File类的成员变量：
 *      public static final String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串
 *      public static final char pathSeparatorChar 与系统有关的路径分隔符
 *
 *      public static final String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串
 *      public static final char separatorChar 与系统有关的默认名称分隔符
 *
 * 操作路径：路径不能写死了
 * C:\develop\a\a.txt   windows
 * c:/develop/a/a.txt   Linux
 * 正确写法：
 * "C:" + File.separator + "develop" + File.separator + "a" + File.separator + "a.txt"
 * */
public class Demo01File {
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        //路径分隔符是分隔多个路径之间的符号
        System.out.println(pathSeparator);      //路径分隔符 windows：分号";"  Linux：冒号":"

        String separator = File.separator;
        //左正又反
        System.out.println(separator);          //文件名称分隔符 windows：反斜杠"\" Linux：正斜杠"/"
    }
}
