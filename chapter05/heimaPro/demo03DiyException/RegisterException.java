package chapter05.heimaPro.demo03DiyException;

public class RegisterException extends Exception {
    //添加一个空参数的构造方法
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);
    }
}
