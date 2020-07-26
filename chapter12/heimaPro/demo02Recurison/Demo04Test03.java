//递归打印多级目录
package chapter12.heimaPro.demo02Recurison;

import java.io.File;

/*
 * 练习：递归打印多级目录
 * 需求：
 *      遍历F:\Java\Project\Study\src\chapter12\\heimaPro文件夹的子文件夹
 *      只要.java结尾的文件
 * */
public class Demo04Test03 {
    public static void main(String[] args) {
        File file = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro");
        getAllFile(file);
    }

    /*
     * 定义一个方法，参数传递File类型的目录，方法中对目录进行遍历
     * 问题：遍历的结果不完全，只有子文件夹，没有子文件夹中的内容
     * 解决：
     *      对遍历得到的File对象进行判断，判断是否是文件夹
     *      如果是就调用方法自己，如果不是就说明是文件，直接打印
     * */
    public static void getAllFile(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            //对遍历得到的File对象f进行判断其是否为文件夹
            if (f.isDirectory()) {
                //直接调用自己，递归
                getAllFile(f);
            } else {        //f是一个文件
/*                 //只要.java结尾的文件
//                String name = f.getName();      //文件名 XXX.XXX
//                String path = f.getPath();    //路径
                //1、把File对象f，转为字符串对象
                String s = f.toString();        //同f.getPath()
                //把字符串转换为小写
                s = s.toLowerCase();

                //2、调用String类中的方法endWith判断字符串是否是以.java结尾
                boolean b = s.endsWith(".java");

                //3、如果是以.java结尾的文件，则输出
                if (b) {
                    System.out.println(f);
                }*/

                //链式编程
                if (f.getName().toLowerCase().endsWith(".java")) {
                    System.out.println(f);
                }
            }
        }
    }
}
