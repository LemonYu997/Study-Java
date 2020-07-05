//8.2 创建一个完整的框架
package chapter8.test02SizedFrame;


import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author mly
 * */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SizedFrame extends JFrame {
    public SizedFrame() {
        //得到屏幕分辨率大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //设置框架大小，及其在屏幕的位置
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        //设置图标
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}
