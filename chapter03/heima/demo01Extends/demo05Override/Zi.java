package chapter03.heima.demo01Extends.demo05Override;

public class Zi extends Fu {

    //子类方法的返回值必须【小于等于】父类方法的返回值范围。
    //子类方法的权限必须【大于等于】父类方法的权限修饰符
    @Override
    public String method() {
        return null;
    }
}
