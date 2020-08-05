//BS版本服务器
package chapter13.heimaPro.demo04BS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 创建BS(浏览器/服务器)版本TCP服务器
 * */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建一个服务器ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8080);

        /*
         * 浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独的开启一个线程，读取服务器的图片
         * 就得让服务器一直处于监听状态，客户端请求一次，服务器就回写一次
         * */
        while (true) {
            //2、使用ServerSocket对象中的方法accept，获取到请求的客户端Socket对象(浏览器)
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3、使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = is.read(bytes)) != -1) {
//            System.out.println(new String(bytes, 0, len));
//        }

                        //把is网络字节输入流对象，转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        //把客户端请求信息的第一行读取出来      GET /xxx/xxx/index.html HTTP/1.1
                        String line = br.readLine();
                        //把读取的信息进行切割，只要中间的部分 /xxx/xxx/index.html
                        String[] arr = line.split(" ");
                        //把路径前边的 / 去掉，进行截取 xxx/xxx/index.html
                        String htmlpath = arr[1].substring(1);

                        //创建一个本地字节输入流，构造方法中绑定要读取的html路径
                        FileInputStream fis = new FileInputStream(htmlpath);

                        //使用Socket中的方法getOutStream获取网络字节输出流OutputStream对象
                        OutputStream os = socket.getOutputStream();

                        //写入HTTP协议响应头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //一读一写复制文件，把服务读取的html文件回写到客户端
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }

                        //释放资源
                        fis.close();;
                        socket.close();
                        server.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();
        }
    }
}
