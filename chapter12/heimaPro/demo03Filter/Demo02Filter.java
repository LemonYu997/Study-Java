//FileNameFilter过滤器
package chapter12.heimaPro.demo03Filter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo02Filter {
    public static void main(String[] args) {
        File file = new File("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro");
        getAllFile(file);
    }

    public static void getAllFile(File dir) {
        //传递过滤器，使用匿名内部类
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                //过滤规则：pathname式文件夹或者.java结尾的文件返回true
//                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
//            }
//        });

//        //传递过滤器FilenameFilter，使用匿名内部类
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                //过滤规则：pathname式文件夹或者.java结尾的文件返回true
//                //将name和路径组合成完整路径判断其是否为文件夹
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
//            }
//        });

        //使用lambda表达式优化匿名内部类(接口中只有一个抽象方法)
        File[] files = dir.listFiles((File d, String name)->{
            //过滤规则：pathname式文件夹或者.java结尾的文件返回true
            return new File(d, name).isDirectory() || name.toLowerCase().endsWith(".java");
        });

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
