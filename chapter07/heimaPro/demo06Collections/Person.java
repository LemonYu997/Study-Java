////Collections中的sort方法
package chapter07.heimaPro.demo06Collections;

//被排序的集合里边存储的元素，必须实现Comparable接口，重写接口中的方法compareTo定义排序的规则
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写排序的规则
    @Override
    public int compareTo(Person o) {
//        return 0;       //认为元素都是相同的

        //自定义比较的规则，比较两个人的年龄(this, 参数Person)
        //按照年龄升序排序
        return this.getAge() - o.getAge();

    }
}
