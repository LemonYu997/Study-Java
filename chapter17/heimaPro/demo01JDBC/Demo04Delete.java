//DML
package chapter17.heimaPro.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 练习：
 * 1、account 表中添加一条记录   INSERT语句
 * 2、account 修改记录
 * 3、account 删除记录
 * */
//修改记录
public class Demo04Delete {
    public static void main(String[] args) {
        //提升作用域
        Statement stmt = null;
        Connection conn = null;

        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false&serverTimezone=UTC", "root", "root");
            //3、定义sql
            String sql = "delete from account where id = 3";
            //4、获取执行sql对象
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql);
            //6、处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //避免出现空指针异常
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
