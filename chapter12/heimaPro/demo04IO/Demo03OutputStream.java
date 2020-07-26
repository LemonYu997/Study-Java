//追加写入/续写，写换行
package chapter12.heimaPro.demo04IO;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 追加写入/续写，使用FileOutputStream类的构造方法：
 * FileOutputStream(String name, boolean append) 创建一个向具有指定 name 的文件中写入数据的输出文件流
 * FileOutputStream(File file, boolean append) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流
 *
 * 参数：
 *      String name，File file写入数据的目的地
 *      boolean append：追加写的开关
 *          true：创建对象不会覆盖原文件，继续在文件的末尾加写数据
 *          false：创建一个新文件，覆盖源文件
 *
 * 写换行：写换行符号
 *      windows：\r\n
 *      linux：/n
 *      mac：/r
 * */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        //创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo04IO\\test2.txt", true);
        for (int i = 0; i < 10; i++) {
            fos.write("世界".getBytes());
            fos.write("\r\n".getBytes());       //换行写
        }

        fos.close();
    }
}
