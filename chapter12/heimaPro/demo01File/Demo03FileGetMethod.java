//File类的常用方法
package chapter12.heimaPro.demo01File;

import java.io.File;

/*
 * File类获取功能的方法：
 * public String getAbsolutePath()：返回此File的绝对路径名字符串
 * public String getPath()：将此File转换为路径名字符串
 * public String getName()：返回由此File表示的文件或目录的名称
 * public long length()：返回由此File标识的文件的长度
 * */
public class Demo03FileGetMethod {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    /*
     * public String getAbsolutePath()：返回此File的绝对路径名字符串
     * 获取的构造方法中传递的路径
     * 无论路径是绝对的还是相对的，getAbsolutePath方法返回的都是绝对路径
     * */
    private static void show01() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        String absolutePath1 = f1.getAbsolutePath();
        System.out.println(absolutePath1);      //F:\Java\Project\Study\src\chapter12\heimaPro\demo01File\Test.txt

        File f2 = new File("Test.txt");
        String absolutePath2 = f2.getAbsolutePath();
        System.out.println(absolutePath2);      //F:\Java\Project\Study\Test.txt
        System.out.println("------------------------------------------------------------");
    }

    /*
     * public String getPath()：将此File转换为路径名字符串
     * 获取的构造方法中传递的路径
     * */
    private static void show02() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        File f2 = new File("Test.txt");
        String path1 = f1.getPath();
        System.out.println(path1);          //F:\Java\Project\Study\src\chapter12\heimaPro\demo01File\Test.txt
        String path2 = f2.getPath();
        System.out.println(path2);          //Test.txt

        /*
         * toString方法调用的就是getPath方法
         * public String toString() {
         *      return getPath();
         *  }
         * */
        System.out.println(f1);             //F:\Java\Project\Study\src\chapter12\heimaPro\demo01File\Test.txt
        System.out.println(f1.toString());  //F:\Java\Project\Study\src\chapter12\heimaPro\demo01File\Test.txt
        System.out.println("------------------------------------------------------------");
    }

    /*
     * public String getName()：返回由此File表示的文件或目录的名称
     * 获取就是构造方法传递路径的结尾部分(文件/文件夹)
     * */
    private static void show03() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        File f2 = new File("Test.txt");
        String name1 = f1.getName();
        System.out.println(name1);      //Test.txt
        String name2 = f2.getName();
        System.out.println(name2);      //Test.txt
    }

    /*
     * public long length()：返回由此File标识的文件的长度
     * 获取的是构造方法指定的文件的大小，以字节为单位
     * 注意：
     *      文件夹没有大小概念，不能获取文件夹大小
     *      如果构造方法中给出的路径不存在，那么length方法返回0
     * */
    private static void show04() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File");
        File f2 = new File("src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        File f3 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        long l1 = f1.length();
        System.out.println(l1);     //0     文件夹没有大小概念
        long l2 = f2.length();
        System.out.println(l2);     //49    相对路径
        long l3 = f3.length();
        System.out.println(l3);     //49    绝对路径
    }
}
