package chapter03.heima.demo01Extends.demo06OverrideUse;

//定义一个新手机，使用老手机作为父类
public class NewPhone extends Phone {

    @Override
    public void show() {
        //把父类的show方法拿过来重复利用
        super.show();
        //自己子类再来添加更多内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
