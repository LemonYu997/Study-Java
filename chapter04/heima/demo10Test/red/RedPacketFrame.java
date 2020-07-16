package chapter04.heima.demo10Test.red;

public abstract class RedPacketFrame {
    private String OwnerName;
    private OpenMode openWay;

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public OpenMode getOpenWay() {
        return openWay;
    }

    public void setOpenWay(OpenMode openWay) {
        this.openWay = openWay;
    }



    /**
     * 构造方法：生成红包界面
     *
     * @param title 界面的标题
     * */
    public RedPacketFrame(String title) {
        System.out.println("界面标题是" + title);
    }
}
