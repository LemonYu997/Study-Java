//创建删除功能的方法
package chapter12.heimaPro.demo01File;

import java.io.File;
import java.io.IOException;

/*
 * public boolean createNewFile()：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
 * public boolean delete()：删除由此File表示的文件或目录
 * public boolean mkdir()：创建由此File表示的目录
 * public boolean mkdirs()：创建由此File表示的目录，包括任何必须但不存在的父目录
 * */
public class Demo05FileMakeMethod {
    public static void main(String[] args) throws IOException {
        show01();
        show02();
        show03();
    }


    /*
     * public boolean createNewFile()：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
     * 创建文件的路径和名称在构造方法中给出(构造方法的参数)
     * 返回值：布尔值
     *      true：文件不存在，创建文件，返回true
     *      false：文件存在，不会创建，返回false
     * 注意：
     *      1、此方法只能创建文件，不能创建文件夹
     *      2、创建文件的路径必须存在，否则会抛出异常
     *      3、不区分大小写。。。。
     *
     * public boolean createNewFile() throws IOException
     * createNewFile声明抛出了IOException，我们调用这个方法，就必须得处理这个异常，要么throws，要么tryCatch
     * */
    private static void show01() throws IOException {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\test1.txt");
        boolean b1 = f1.createNewFile();
        System.out.println(b1);

        File f2 = new File("src\\chapter12\\heimaPro\\demo01File\\test2.txt");
        System.out.println(f2.createNewFile());
        System.out.println("--------");
    }

    /*
     * public boolean mkdir()：创建单级空文件夹
     * public boolean mkdirs()：既可以创建单级空文件夹，也可以创建多级文件夹
     * 创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
     * 返回值：布尔值
     *      true：文件夹不存在，创建文件，返回true
     *      false：文件夹存在，不会创建，返回false，构造方法中给出的路径不存在返回false
     * 注意：
     *      1、此方法只能创建文件夹，不能创建文件
     *      2、不区分大小写
     * */
    private static void show02() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test");
        boolean b1 = f1.mkdir();
        System.out.println(b1);
        File f2 = new File("src\\chapter12\\heimaPro\\demo01File\\test");
        System.out.println(f2.mkdir());     //不区分大小写

        File f3 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test\\test\\test");
        System.out.println(f3.mkdirs());    //创建多级文件夹

        File f4 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\abc.txt");
        System.out.println(f4.mkdir());     //成功，类型是一个文件

        File f5 = new File("xxxx\\aaaa");
        System.out.println(f5.mkdir());     //没有抛出异常，但是路径不存在，不会创建
        System.out.println("-------------");
    }

    /*
     * public boolean delete()：删除由此File表示的文件或目录
     * 此方法，可以删除构造方法路径中给出的文件/文件夹
     * 返回值：布尔值
     *      true：文件/文件夹删除成功
     *      false：文件夹中有内容，不会删除false，构造方法中路径不存在false
     * 注意：
     *      delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除要谨慎
     * */
    private static void show03() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\test1.txt");
        boolean b1 = f1.delete();
        System.out.println(b1);
        File f2 = new File("src\\chapter12\\heimaPro\\demo01File\\test2.txt");
        System.out.println(f2.delete());
        File f3 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test");
        System.out.println(f3.delete());        //不能批量删除
        File f4 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\abc.txt");
        System.out.println(f4.delete());
    }
}
