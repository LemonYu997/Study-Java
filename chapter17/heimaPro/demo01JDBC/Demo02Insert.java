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
//表中添加记录
public class Demo02Insert {
    public static void main(String[] args) {
        //提升作用域
        Statement stmt = null;
        Connection conn = null;

        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、定义sql
            String sql = "INSERT INTO account VALUES(null, '王五', 3000)";
            //3、获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false&serverTimezone=UTC", "root", "root");
            //4、获取执行sql的对象 statement
            stmt = conn.createStatement();
            //5、执行sql
            int count = stmt.executeUpdate(sql);        //返回值是 该语句影响的行数
            //6、处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
            //7、释放资源
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
