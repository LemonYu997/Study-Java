//10.6 组合框——下拉选项
package chapter10.comboBox;

import javax.swing.*;
import java.awt.*;

/**
 * 带有简单文本标签和选择字体大小的组合框的框架
 */
public class CombonBoFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public CombonBoFrame() {
        //添加简单文本标签
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //创建一个组合框并且添加选项
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //组合框监听器根据选择的选项改变标签字体
        faceCombo.addActionListener(event -> label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN, DEFAULT_SIZE)));

        //在框架的南边框处添加组合框面板
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }
}
