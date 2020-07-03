//9.4 鼠标
package chapter9.mouse;

import javax.swing.*;
import java.awt.*;

//输出
public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            MouseFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
