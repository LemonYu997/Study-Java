package chapter10.comboBox;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            CombonBoFrame frame = new CombonBoFrame();
            frame.setTitle("ComboBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
