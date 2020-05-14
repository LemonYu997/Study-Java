//2.2 更改器方法和访问器方法
package chapter2;

import java.time.DayOfWeek;
import java.time.LocalDate;

//输出一个当前月份的日历
public class CalendarTest {
    public static void main(String[] args) {
        //构造一个日历对象，用当前的日期和时间进行初始化
        LocalDate date = LocalDate.now();
        //获得当前的月和日
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //将date设置为这个月的第一天，并得到这一天为星期几
        date = date.minusDays(today - 1);           //LocalDate minusDays(int n) 生成当前之后或之前n天的日期
        DayOfWeek weekday = date.getDayOfWeek();    //得到当前日期是星期几
        int value = weekday.getValue();             //1是周一，7是周日

        //打印表头和第一行缩进
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        //打印日历主体
        while (date.getMonthValue() == month)       //只打印本月日期
        {
            //从第一天开始打印
            System.out.printf("%3d", date.getDayOfMonth());
            //如果是今天，在其前加 * 表示
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            //日期向后推一天
            date = date.plusDays(1);
            //如果下一天是周一，就换行打印
            if (date.getDayOfWeek().getValue() == 1)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1)
            System.out.println();
    }
}
