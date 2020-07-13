//9.4 鼠标组件
package chapter09.test04Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * 一个带有鼠标操作的组件，用于添加和删除方块
 */
public class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;                //包含鼠标光标的方块

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //画所有的方块
        for (Rectangle2D r : squares)
            g2.draw(r);
    }

    /**
     * 找到包含点的第一个方块
     *
     * @param p 一个点
     * @return 包含p的第一个方块
     */
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p))
                return r;
        }
        return null;
    }

    /**
     * 向集合中添加一个方块
     *
     * @param p 方块的中心
     */
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * 向集合中删除一个方块
     *
     * @param s 删除的方块
     */
    public void remove(Rectangle2D s) {
        if (s == null)
            return;
        if (s == current)
            current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            //如果光标不在方块内，添加一个方块
            current = find(event.getPoint());
            if (current == null)
                add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event) {
            //双击鼠标删除当前方块
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {
            //如果在方块内部，将鼠标光标设置为十字线
            if (find(event.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                //拖动当前方块的中心到(x, y)
                current.setFrame(x - SIDELENGTH, y - SIDELENGTH, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }

}
