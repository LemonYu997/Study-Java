//使用字节流读取中文文件
package chapter12.heimaPro.demo04IO;

        import java.io.FileInputStream;
        import java.io.IOException;
/*
 * 使用字节流读取中文文件
 * 1个中文
 *      GBK：占用两个字节
 *      UTF-8：占用3个字节
 * 容易产生乱码
 * */
public class Demo07Chinese {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo04IO\\test3.txt");
        int len = 0;
        while((len = fis.read()) != -1) {
            System.out.println(/*(char)*/len);
        }
        fis.close();
    }
}
