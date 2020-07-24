//绝对路径和相对路径
//File类的构造方法
package chapter12.heimaPro.demo01File;

import java.io.File;

/*
 * 路径：
 *      绝对路径：是一个完整的路径，以盘符(C:...)开始的路径
 *          C:\\a.txt
 *          C:\\Users\\java\\IdeaProject
 *      相对路径：是一个简化的路径
 *          相对指的是相对于当前项目的根目录(C:\\Users\\java\\IdeaProject)
 *          如果使用当前项目的根目录，路径就可以简化书写
 *          C:\\Users\\java\\IdeaProject\\a.txt --> a.txt
 *
 * 注意：
 *      1、路径是不区分大小写
 *      2、路径中的文件名称分隔符windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠
 * */
public class Demo02FilePath {
    /*
     * File类的构造方法：
     * */
    public static void main(String[] args) {
        show01();
        show02("c:", "a.txt");      //c:\a.txt
        show02("d:", "a.txt");      //d:\a.txt
        show03();
    }

    /*
     * File(String pathname)通过将给定路径名字字符串转换为抽象路径名来创建一个新的File实例
     * 参数：
     *      String pathname：字符串的路径名称
     * 注意：
     *      1、路径可以是以文件结尾，也可以是以文件夹结尾
     *      2、路径可以是相对路径也可以是绝对路径
     *      3、路径可以是存在，也可以是不存在
     *      4、创建File对象，只是把字符串路径封装为File对象，不考虑路径的真假情况
     * */
    private static void show01() {
        //路径存在，文件
        File f1 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo01File\\Test.txt");
        //重写了Object的toString方法，打印了路径
        System.out.println(f1);     //F:\Java\Project\Study\src\chapter12\heimaPro\demo01File\Test.txt

        //路径不存在，文价夹
        File f2 = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo233File");
        System.out.println(f2);     //F:\Java\Project\Study\src\chapter12\heimaPro\demo233File

        //相对路径，文件不存在
        File f3 = new File("test.txt");
        System.out.println(f3);     //test.txt
    }

    /*
     * File(String parent, String child) 根据parent路径字符串和child路径字符串创建一个新的File实例
     * 参数：把路径分成了两部分
     *      String parent：父路径
     *      String child：子路径
     * 好处：
     *      父路径和子路径，可以单独书写，使用起来非常灵活：父路径和子路径都可以变化
     * */
    private static void show02(String parent, String child) {
        File file = new File(parent, child);
        System.out.println(file);
    }

    /*
     * File(File parent, String child) 根据parent抽象路径名和child路径字符串创建一个新的File实例
     * 参数：把路径分成了两部分
     *      File parent：父路径
     *      String child：子路径
     * 好处：
     *      父路径和子路径，可以单独书写，使用起来非常灵活：父路径和子路径都可以变化
     *      父路径是File类型，可以使用File的方法，对路径进行一些操作，再使用路径创建对象
     * */
    private static void show03() {
        File parent = new File("c:\\");
        File file = new File(parent, "hello.java");
        System.out.println(file);           //c:\hello.java
    }
}
