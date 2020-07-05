//输出ASCII表
package chapter1.heima.demo02Variate;

public class PrintAscii {
    public static void main(String[] args) {
        //输出ASCII码表
        for (int i = 1; i < 128; i++) {
            System.out.println((char)i + " : " + i);
        }
    }
}
