package chapter04.heima.demo05Modifier.sub;

//子包仍然需要导包语句
import chapter04.heima.demo05Modifier.MyClass;

public class MySon extends MyClass {
    public void methodSon() {
        System.out.println(super.num);
    }
}
