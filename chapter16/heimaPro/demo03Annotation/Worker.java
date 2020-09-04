package chapter16.heimaPro.demo03Annotation;

@MyAnno3
public class Worker {

    @MyAnno3
    public String name = "Jack";

    @MyAnno3
    public void show() {
        System.out.println("show...");
    }
}
