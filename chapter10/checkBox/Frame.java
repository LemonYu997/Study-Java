package chapter10.checkBox;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            CheckBoxFrame frame = new CheckBoxFrame();
            frame.setTitle("CheckBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
