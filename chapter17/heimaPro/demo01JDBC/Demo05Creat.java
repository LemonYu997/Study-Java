//DDL
package chapter17.heimaPro.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * DDL：创建数据库或表
 */
public class Demo05Creat {
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
            String sql = "create table student (id int, name varchar(20))";
            //4、获取执行sql对象
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql);
            //6、处理结果
            System.out.println(count);
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