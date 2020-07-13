//9.2 观感
package chapter09.test02Plaf;

import javax.swing.*;
import java.awt.*;

//输出
public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            PlafFrame frame = new PlafFrame();
            frame.setTitle("plafTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
