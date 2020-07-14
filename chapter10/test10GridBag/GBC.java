//网格组布局
package chapter10.test10GridBag;

import javax.crypto.interfaces.PBEKey;
import java.awt.*;

/**
 * 简化使用GridBagConstraints类
 * @author mly
 * @version 1.0
 */
public class GBC extends GridBagConstraints {
    /**
     * 使用给定的gridx和gridy位置以及设置为默认的所有其他网格组值构造一个GBC
     * @param gridx gridx位置
     * @param gridy gridy位置
     */
    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * 使用给定的gridx和gridy，gridwidth，gridheight以及设置为默认的所有其他网格组值构造一个GBC
     * @param gridx      gridx位置
     * @param gridy      gridy位置
     * @param gridwidth  单元格在x方向上延伸
     * @param gridheight 单元格在y方向上延伸
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    /**
     * 设置锚
     * @param anchor 锚的值
     * @return 此对象用于进一步修改
     * */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * 设置填充方向
     * @param fill 填充方向
     * @return  此对象用于进一步修改
     * */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * 设置单元格权重
     * @param weightx 单元格在x方向的权重
     * @param weighty 单元格在y方向的权重
     * @return 此对象用于进一步修改
     * */
    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * 设置此单元格的insets
     * @param distance 间距要用在所有的方向上
     * @return 此对象用于进一步修改
     * */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * 设置此单元格的insets
     * @param top 顶部的间距
     * @param left 左侧的间距
     * @param bottom 底部的间距
     * @param right 右侧的间距
     * @return 此对象用于进一步修改
     * */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * 设置内部填充
     * @param ipadx 内部填充在x方向
     * @param ipady 内部填充在y方向
     * @return 此对象用于进一步修改
     * */
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
