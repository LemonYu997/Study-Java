package chapter10.test09ToolBar;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            ToolBarFrame frame = new ToolBarFrame();
            frame.setTitle("ToolBarTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
