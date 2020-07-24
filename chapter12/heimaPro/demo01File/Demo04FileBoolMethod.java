//File类判断功能的方法
package chapter12.heimaPro.demo01File;

import java.io.File;

/*
 * File类判断功能的方法
 * public boolean exists() ：此File表示的文件或目录是否实际存在
 * public boolean isDirectory()：此File表示的是否为目录
 * public boolean isFile()：此File表示的是否为文件
 * */
public class Demo04FileBoolMethod {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /*
     * public boolean exists() ：此File表示的文件或目录是否实际存在
     * 用于判断构造方法中的路径是否存在
     *      存在：true
     *      不存在：false
     * */
    private static void show01() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        System.out.println(f1.exists());        //true      绝对路径
        File f2 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\est.txt");
        System.out.println(f2.exists());        //false     不存在路径
        File f3 = new File("src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        System.out.println(f3.exists());        //true      相对路径
        System.out.println("---------------");
    }

    /*
     * public boolean isDirectory()：此File表示的是否为目录
     * 用于判断构造方法中给定的路径是否以文件夹结尾
     *      是：true
     *      否：false
     * public boolean isFile()：此File表示的是否为文件
     * 用于判断构造方法中给定的路径是否以文件夹结尾
     *      是：true
     *      否：false
     * 注意：
     *      电脑的硬盘中只有文件/文件夹，两个方法是互斥的
     *      这两个方法使用前提，路径必须是存在的，否则都返回false
     * */
    private static void show02() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");

        //不存在，就没有必要获取
        if(f1.exists()) {
            System.out.println(f1.isDirectory());       //false
            System.out.println(f1.isFile());            //true
        }

        File f2 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File");
        if(f2.exists()) {
            System.out.println(f2.isDirectory());       //true
            System.out.println(f2.isFile());            //false
        }
    }
}
