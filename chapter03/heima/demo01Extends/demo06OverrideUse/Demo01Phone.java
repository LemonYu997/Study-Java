//继承中方法覆盖重写的应用
package chapter03.heima.demo01Extends.demo06OverrideUse;

public class Demo01Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.call();
        phone.send();
        phone.show();
        System.out.println("-------------------");

        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}
