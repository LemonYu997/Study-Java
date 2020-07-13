//流程控制3——Switch
package chapter01.heima.demo03ProcessControl;

/* 注意事项：
 * 1、多个case后面的数值不可以重复
 * 2、switch后面小括号当中只能是下列数据类型：
 *   基本数据类型：byte/short/char/int
 *   引用数据类型：String字符串、enum枚举
 * 3、switch语句格式可以很灵活：前后顺序可以颠倒，而且break语句还可以省略
 *
 *
 * 【重要】
 * 匹配到哪一个case就从哪一个位置向下执行，知道遇到了break或整体结束为止
 * */

public class Demo03Switch {
    public static void main(String[] args) {
        int num = 6;

        switch (num) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Error number");
                break;                  //最后一个break可以省略，但强烈推荐不要省略
        }
    }
}

