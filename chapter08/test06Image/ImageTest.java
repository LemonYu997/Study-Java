//8.6 图像显示
package chapter08.test06Image;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author mly
 * */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * 带有图像消息组件的框架
 * */
class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}

/**
 * 显示平埔图像的组件
 * */
class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    public ImageComponent() {
        image = new ImageIcon("blue-ball.gif").getImage();
    }

    public void paintComponent(Graphics g) {
        if (image == null)
            return;

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        //在左上角画图
        g.drawImage(image, 0, 0, null);

        //在组件中平埔图像
        for (int i = 0; i * imageWidth <= getWidth() ; i++) {
            for (int j = 0; j * imageHeight <= getHeight() ; j++) {
                if (i + j > 0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}