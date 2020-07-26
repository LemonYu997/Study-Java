//File类遍历目录功能
package chapter12.heimaPro.demo01File;

import java.io.File;

/*
 * File类遍历(文件夹)目录功能
 * public String[] list()：返回一个String数组，表示该File目录中的所有子文件或目录
 * public File[] listFiles()：返回一个File数组，表示该File目录中的所有的子文件或目录
 *
 * 注意：
 *      list方法和listFiles方法遍历的是构造方法中给出的目录
 *      如果构造方法中给出的目录的路径不存在，会抛出空指针异常
 *      如果构造方法中给出的路径不是一个目录，也会抛出空指针异常
 * */
public class Demo06FileRecurison {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /*
     * public String[] list()：返回一个String数组，表示该File目录中的所有子文件或目录
     * 遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称存储到一个String类型的数组中
     *
     * */
    private static void show01() {
        //得是一个存在的目录路径，否则会出现空指针异常NullPointerException
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File");
        String[] arr = f1.list();
        for (String fileName : arr) {
            System.out.println(fileName);
        }
    }

    /*
     * public File[] listFiles()：返回一个File数组，表示该File目录中的所有的子文件或目录
     * 遍历构造方法中给出的目录，会获取目录中所有的文件/文件夹，把文件/文件夹封装为File对象，多个File对象存储到File数组中
     * */
    private static void show02() {
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File");
        File[] files = f1.listFiles();
        for (File f : files) {
            System.out.println(f);      //打印路径
        }
    }
}
