//编码引出问题        转换流
package chapter12.heimaPro.demo09TransformationFlow;

import java.io.FileReader;
import java.io.IOException;

/*
 * GBK 中文两字节 UTF-8 中文三字节
 * IDEA默认UTF-8，读取GBK中文会出现乱码。
 * */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo09TransformationFlow\\GBKtest.txt");
        int read;
        while((read = fr.read()) != -1) {
            System.out.print((char)read);   //���
        }
        fr.close();
    }
}
