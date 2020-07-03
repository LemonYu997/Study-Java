//9.3 动作
package chapter9.action;

import javax.swing.*;
import java.awt.*;

//输出
public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            ActionFrame frame = new ActionFrame();
            frame.setTitle("ActionTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
