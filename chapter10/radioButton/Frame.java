package chapter10.radioButton;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            RadioButtonFrame frame = new RadioButtonFrame();
            frame.setTitle("RadioButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
