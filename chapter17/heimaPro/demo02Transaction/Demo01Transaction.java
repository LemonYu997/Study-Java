//事务操作
package chapter17.heimaPro.demo02Transaction;

import chapter17.heimaPro.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC控制事务
 * 事务：一个包含多个步骤的业务操作，如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败
 * 操作：
 *      1、开启事务
 *      2、提交事务
 *      3、回滚事务
 * 使用Connection对象来管理事务
 * 1、开启事务：SetAutoCommit(boolean autoCommit)：调用该方法设置参数为false，即开启事务
 *      在执行sql之前开启事务
 * 2、提交事务：commit()
 *      当所有sql都执行完提交事务
 * 3、回滚事务：rollback()
 *      在catch中回滚事务
 * 案例：转账操作
 * */
public class Demo01Transaction {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1、获取连接：
            conn = JDBCUtils.getConnection();
            //2、开启事务
            conn.setAutoCommit(false);
            //3、定义sql
            //3.1 张三 - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //3.2 李四 + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //4、获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //5、设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            //6、执行sql
            pstmt1.executeUpdate();
            //手动制造异常
            int i = 3/0;        //如果没有开启事务，张三的钱减了，但李四的钱没加
            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, null);
            JDBCUtils.close(pstmt2, conn);
        }
    }
}
