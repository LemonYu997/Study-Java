//使用连接池工具类
package chapter17.heimaPro.demo04Druid;

import chapter17.heimaPro.util.JDBCPoolUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 练习：完成添加操作，在account表中添加一条记录
 */
public class Demo02Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1、获取连接
            conn = JDBCPoolUtils.getConnection();
            //2、定义sql
            String sql = "insert into account values(null, ?, ?)";
            //3、获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4、给?赋值
            pstmt.setString(1, "王五");
            pstmt.setDouble(2, 3000);
            //5、执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6、释放资源
            JDBCPoolUtils.close(pstmt, conn);
        }
    }
}
