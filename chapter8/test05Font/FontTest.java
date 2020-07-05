//8.5 字体
package chapter8.test05Font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 选择字体，绘制基线和字符串边框
 * @version 1.0
 * @author mly
 * */
public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * 带有文本消息组件的框架
 * */
class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
    }
}

/**
 * 在框中显示居中消息的组件
 * */
class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Hello, World!";

        //字体设置
        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        //测量字符串大小，画框
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        //(x, y)为文本框左上角
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        //增加y到达基线位置
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        //绘制字符串
        g2.drawString(message, (int)x, (int)baseY);
        g2.setPaint(Color.LIGHT_GRAY);

        //画基线
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        //画一个矩形
        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

