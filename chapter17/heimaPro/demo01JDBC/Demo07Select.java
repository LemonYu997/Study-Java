//DQL
package chapter17.heimaPro.demo01JDBC;

import java.sql.*;

/*
 * 遍历结果
 * */
public class Demo07Select {
    public static void main(String[] args) {
        //提升作用域
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false&serverTimezone=UTC", "root", "root");
            //3、定义sql
            String sql = "select * from account";
            //4、获取执行sql对象
            stmt = conn.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6、处理结果

            //循环判断结果集是否有数据，即游标是否为末尾，如果不是，则向下一行，否则跳出循环
            while(rs.next()) {
                //获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);

                System.out.println(id + "---" + name + "---" + balance);
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
