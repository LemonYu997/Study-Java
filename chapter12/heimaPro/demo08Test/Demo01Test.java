//练习，文本排序
package chapter12.heimaPro.demo08Test;

import java.io.*;
import java.util.HashMap;

/*
 * 练习：
 * 对in.txt文本的内容进行排序，按照(1,2,3...)的顺序
 * 分析：
 * 1、创建一个HashMap集合对象，key：存储每行文本的序号(1,2,3...);value：存储每行的文本
 * 2、创建字符缓冲输入流对象，构造方法中绑定字符输入流
 * 3、创建字符缓冲输出流对象，构造方法中绑定字符输出流
 * 4、使用字符缓冲输入流的方法readLine，逐行读取文本
 * 5、对读取到的文本进行切割，获取行中的序号和文本内容
 * 6、把切割好的序号和文本的内容存储好HashMap集合中(key序号是有序的，会自动排序)
 * 7、遍历HashMap集合，获取每一个键值对
 * 8、把每一个键值对，拼接为一个文本行
 * 9、把拼接好的文本行，使用字符缓冲输出流的方法write写入到文件中
 * 10、释放资源
 *
 * 注意事项：
 * 读取的时候不会读取换行符号，写入的时候要加上换行符号
 * */
public class Demo01Test {
    public static void main(String[] args) throws IOException {
        //1、创建一个HashMap集合对象，key：存储每行文本的序号(1,2,3...);value：存储每行的文本
        HashMap<String, String> map = new HashMap<>();

        //2、创建字符缓冲输入流对象，构造方法中绑定字符输入流
        BufferedReader br = new BufferedReader(new FileReader("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo08Test\\in.txt"));

        //3、创建字符缓冲输出流对象，构造方法中绑定字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo08Test\\out.txt"));

        //4、使用字符缓冲输入流的方法readLine，逐行读取文本
        String line;
        while ((line = br.readLine()) != null) {
            //5、对读取到的文本进行切割，获取行中的序号和文本内容
            String[] arr = line.split("\\.");
            //6、把切割好的序号和文本的内容存储好HashMap集合中(key序号是有序的，会自动排序)
            map.put(arr[0], arr[1]);
        }

        //7、遍历HashMap集合，获取每一个键值对
        for (String key : map.keySet()) {
            String value = map.get(key);
            //8、把每一个键值对，拼接为一个文本行
            line = key + "." + value;
            //9、把拼接好的文本行，使用字符缓冲输出流的方法write写入到文件中
            bw.write(line);
            bw.newLine();       //换行
        }

        //10、释放资源
        bw.close();
        br.close();
    }
}
