//9.4 鼠标
package chapter9.mouse;

import javax.swing.*;

/**
 * 包含测试鼠标操作面板的框架
 * */
public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}
