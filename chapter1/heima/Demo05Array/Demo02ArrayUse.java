//数组的运用
package chapter1.heima.Demo05Array;

/*
 * 直接打印数组名称，得到的是数组对应的：内存地址哈希值。
 *
 * 访问数组元素的格式：数组名称[索引值]
 * 索引值：就是一个int数字，代表数组当中元素的编号
 * 【注意】索引值从0开始，一直到(数组的长度 - 1)为止
 *
 * 使用动态初始化数组的时候，其中元素将会自动拥有一个默认值，规则如下：
 * 1、如果是整数类型，默认为0
 * 2、如果是浮点类型，默认为0.0
 * 3、如果是字符类型，默认为'\u0000'
 * 4、如果是布尔类型，默认为false
 * 5、如果是引用类型，默认为null
 *
 * 注意事项：
 * 1、静态初始化也有默认值的过程，只不过系统自动马上将默认值替换成了大括号当中的具体数值
 * */


public class Demo02ArrayUse {
    public static void main(String[] args) {
        //静态初始化的省略格式
        int[] array1 = {10, 20, 30};
        //直接打印数组名称，得到的是数组对应的：内存地址哈希值。
        System.out.println(array1);      //[I@1b6d3586
        //直接打印数组中的元素
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);

        //将数组当中的某一个元素，赋值交给变量
        int num = array1[1];
        System.out.println(num);
        System.out.println("-----------------------------");

        //动态初始化一个数组
        int[] array2 = new int[3];
        array2[1] = 123;
        System.out.println(array2);     //内存地址值
        System.out.println(array2[0]);  //0
        System.out.println(array2[1]);  //123
        System.out.println(array2[2]);  //0
    }
}
