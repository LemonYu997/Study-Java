//哈希值HashCode
package chapter07.heimaPro.demo04Set;

/*
 * 哈希值HashCode：是一个十进制整数，由系统随机给出(就是对象的地址)，是一个逻辑地址，是模拟出来的地址，不是数据实际存储的地址
 * 在Object类有一个方法，可以获取对象的哈希值     int hashCode() 返回该对象的哈希值
 *
 * hashCode方法的源码：
 *      public native int hashCode();
 *      native：代表该方法调用的是本地操作系统的方法
 * */
public class Demo02HashCode {
    public static void main(String[] args) {
        //Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person1 p1 = new Person1();
        int h1 = p1.hashCode();
        System.out.println(h1);     //460141958     |   1   (重写后)

        Person1 p2 = new Person1();
        int h2 = p2.hashCode();
        System.out.println(h2);     //1163157884    |   1   (重写后)

        /*
         * toString方法的源码：
         *       public String toString() {
         *          return getClass().getName() + "@" + Integer.toHexString(hashCode());
         *       }
         *
         * 输出的是16进制的哈希值
         * */
        System.out.println(p1);     //chapter07.heimaPro.demo04Set.Person@1b6d3586 (16进制)     |   1   (重写后)
        System.out.println(p2);     //chapter07.heimaPro.demo04Set.Person@4554617c (16进制)     |   1   (重写后)
        System.out.println(p1 == p2);       //false 即使重写后返回值都是1，但并没有改变地址，地址仍是不一样的
        System.out.println("-----------------------------------------------");

        /*
         * String类的哈希值
         * String类重写了Object类的hashCode方法
         * public int hashCode() {
               int h = hash;
         *     if (h == 0 && value.length > 0) {
         *         char val[] = value;
         *
         *         for (int i = 0; i < value.length; i++) {
         *             h = 31 * h + val[i];
         *         }
         *         hash = h;
         *     }
         *     return h;
         * }
        * */
        String s1 = new String("abc");
        String s2 = new String("abc");
        //元素相同，哈希值相同
        System.out.println(s1.hashCode());          //96354
        System.out.println(s2.hashCode());          //96354
        //元素不同，哈希值【可能】不同
        System.out.println("苍蓝星".hashCode());     //33259631
        System.out.println("灭灭子".hashCode());     //28574128
        //哈希值相同，元素【不一定】相同
        System.out.println("重地".hashCode());     //1179395
        System.out.println("通话".hashCode());     //1179395
    }
}
