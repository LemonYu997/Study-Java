//流程控制4——循环结构
package chapter01.heima.demo03ProcessControl;

/* 三种循环的区别：
 * 1、如果条件判断没有满足过，那么for循环和while循环会执行0次，但do-while循环至少执行一次
 * 2、for循环的变量在小括号当中定义，只有循环内部才可以使用。
 *    while循环和do-while循环初始化语句本来在外面，所以循环出来后可以继续使用
 *
 * 循环的选择：
 * 凡是次数确定的场景多用for循环，否则多用while循环
 *
 * break关键字的常见用法：
 * 1、在switch语句中，一旦执行，整个switch语句立刻结束
 * 2、在循环语句中，一旦执行，整个循环语句立即结束，打断循环。
 *
 * continue语句：
 * 一旦执行，立刻跳过当前次循环剩余内容，马上开始下一次循环
 *
 * 永远停不下来的循环叫做死循环。标准格式：
 * while (true) {
 *      循环体
 * }
 * */


public class Demo04Circulation {
    public static void main(String[] args) {
        forTest();
        whileTest();
        doWhileTest();
        breakTest();
        continueTest();
    }

    //for循环
    public static void forTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我错了！" + i);
        }
        System.out.println("-------------------------");
    }

    //while循环
    public static void whileTest() {
        int i = 1;                                  //1、初始化语句
        while (i <= 10) {                           //2、条件判断
            System.out.println("我错啦！ " + i);    //3、循环体
            i++;                                    //4、步进语句
        }
        System.out.println("-------------------------");
    }

    //do-while循环
    public static void doWhileTest() {
        int i = 1;                                  //1、初始化语句
        do {
            System.out.println("起来吧");            //3、循环体
            i++;                                    //4、步进语句
        } while (i <= 10);                          //2、条件判断
        System.out.println("-------------------------");
    }

    //break语句
    public static void breakTest() {
        for (int i = 1; i <= 10; i++) {
            //从第4次开始，之后打断循环
            if (i == 4) {
                break;
            }
            System.out.println("Hello " + i);
            System.out.println("-------------------------");
        }
    }

    //continue语句
    public static void continueTest() {
        for (int i = 1; i <= 10; i++) {
            //跳过第4次，循环继续
            if (i == 4) {
                continue;
            }
            System.out.println("Hello " + i);
        }
    }

    //死循环
    public static void deadLoop() {
        while (true) {
            System.out.println("I love java.");
        }

//        System.out.println("Hello");      //报错：死循环后的语句无法访问
    }
}
