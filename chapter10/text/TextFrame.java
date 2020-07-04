package chapter10.text;

import javax.swing.*;
import java.awt.*;

public class TextFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            TextComponentFrame frame = new TextComponentFrame();
            frame.setTitle("TextTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

