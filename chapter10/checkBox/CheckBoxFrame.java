//10.3 选择组件 复选框
package chapter10.checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//两个复选框，字体加粗和字体倾斜

/**
 * 带有简单文本标签和用于选择字体的复选框的框架
 */
public class CheckBoxFrame extends JFrame {
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame() {
        //添加一个简单文本标签
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        //此监听器将标签的字体属性设置为复选框状态
        ActionListener listener = event -> {
            int mode = 0;
            if (bold.isSelected())
                mode += Font.BOLD;
            if (italic.isSelected())
                mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        //添加一个复选框
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
