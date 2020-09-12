//JDBC练习
package chapter17.heimaPro.demo01JDBC;

import chapter17.heimaPro.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 * 1、通过键盘录入用户名和密码
 * 2、判断用户是否登录成功
 * select * from user where username = "" and password = "";
 * 如果这个sql有查询结果，则成功，反之，则失败
 * 步骤：
 * 1、创建数据库表
 */
public class Demo10Test {

    public static void main(String[] args) {
        //1、键盘录入，接收用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2、调用方法
        boolean flag = new Demo10Test().loginBetter(username, password);
        //3、判断结果，输出不同于据
        if (flag) {
            //登录成功
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 登录方法
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //连接数据库判断是否登录成功
        //1、获取链接
        try {
            conn = JDBCUtils.getConnection();
            //2、定义sql
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            //这里的意思相当于 select * from user where username = username(输入的) and password = password(输入的); 双引号是java语句，单引号是sql语句
//            System.out.println(sql);
            //3、获取执行sql的对象
            stmt = conn.createStatement();
            //4、执行查询
            rs = stmt.executeQuery(sql);
            //5、判断
//            if (rs.next()) {
//                //如果有下一行，就返回true
//                return true;
//            } else {
//                return false;
//            }
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return false;
    }


    /**
     * 登录方法，使用PreparedStatement实现
     * 防止SQL注入
     */
    public boolean loginBetter(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //连接数据库判断是否登录成功
        //1、获取链接
        try {
            conn = JDBCUtils.getConnection();
            //2、定义sql
            String sql = "select * from user where username = ? and password = ?";
            //sql参数使用?作为占位符。select * from user where username = ? and password = ?;
//            System.out.println(sql);
            //3、获取执行sql的对象PreparedStatement
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //4、执行查询，不需要传递sql
            rs = pstmt.executeQuery();
            //5、判断
//            if (rs.next()) {
//                //如果有下一行，就返回true
//                return true;
//            } else {
//                return false;
//            }
            return rs.next();       //如果有下一行，则返回true
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return false;
    }
}
