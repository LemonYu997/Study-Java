//3.3 Object类       equals、hashCode、toString
package chapter3.equals;

public class EqualsTest {
    public static void main(String[] args) {
        //创建4个测试对象
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));              //true
        System.out.println("alice1 == alice3: " + (alice1 == alice3));              //false，只是数据相同，但并不是同一个对象
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));      //true，要比较的域相同
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));            //false
        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Creaker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));              //false，bonus不一致
        System.out.println("alice1.hashCode(): " + alice1.hashCode());              //-808853550
        System.out.println("alice3.hashCode(): " + alice3.hashCode());              //-808853550
        System.out.println("bob.hashCode(): " + bob.hashCode());                    //-624019882
        System.out.println("carl.hashCode(): " + carl.hashCode());                  //-341762419
    }
}
