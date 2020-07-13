//2.7 包的导入Part1，用到的Employee5类放在同一个包下的另一个文件中
package chapter02;

//包的静态导入，使用下述语句后就不必加类名前缀
import static java.lang.System.*;

public class Test07PackageTest {
    public static void main(String[] args) {
        //由于Employee5类文件放在同一包下，可以直接使用，否则需要进行导入
        Employee5 harry = new Employee5("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        //因为有上边包的静态导入语句，这里不用加System.
        out.println("name=" + harry.getName() + ", salary=" + harry.getSalary());
    }
}


