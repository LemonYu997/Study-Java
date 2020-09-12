package chapter17.heimaPro.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 概念：
 * JDBC：Java DataBase Connectivity  Java数据库连接，Java语言操作数据库
 * JDBC的本质：JAVA官方(sun公司)定义了操作所有关系型数据库的规则（接口），
 * 各个数据库厂商去实现这套接口，提供数据库驱动jar包。可以使用这套接口编程，真正执行的代码是驱动jar包中的实现类。
 *
 * 快速入门，步骤：
 * 1、导入驱动jar包 mysql-connector-java-8.0.21.jar
 *    1.1 复制mysql-connector-java-8.0.21.jar到项目的libs(自建)目录下
 *    1.2 右键->Add As Library
 * 2、注册驱动
 * 3、获取数据库连接对象Connection
 * 4、定义sql语句
 * 5、获取执行sql语句的对象Statement
 * 6、执行sql，接收返回结果
 * 7、处理结果
 * 8、释放资源
 *
 * 详解各个对象：
 * 1、DriverManager：驱动管理对象
 *    功能：
 *      1.1注册驱动：告诉程序该用哪个数据库驱动jar
 *      static void registerDriver(Driver driver) 向 DriverManager 注册给定驱动程序。
 *      写代码使用 Class.forName("com.mysql.cj.jdbc.Driver");注册驱动
 *      通过查看源码发现，在com.mysql.cj.jdbc.Driver类中存在静态代码块
 *      static {
 *           try {
 *               DriverManager.registerDriver(new Driver());
 *           } catch (SQLException var1) {
 *               throw new RuntimeException("Can't register driver!");
 *           }
 *       }
 *
 *      注意：mysql5之后的jar包可以省略注册驱动的步骤
 *
 *      1.2获取数据库连接
 *      方法：static Connection getConnection(String url, String user, String password) 试图建立到给定数据库 URL 的连接。
 *      参数：
 *          url：指定连接的路径
 *              语法：jdbc:mysql://ip地址(域名):端口号/数据库名称
 *              例子：jdbc:mysql://localhost:3306/db3
 *              细节：如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：jdbc:mysql:///数据库名称
 *          user：用户名
 *          password：密码
 * 2、Connection：数据库连接对象
 *      功能：
 *          1、获取执行sql的对象
 *              Statement createStatement(); 创建一个 Statement 对象来将 SQL 语句发送到数据库。
 *              PreparedStatement prepareStatement(String sql) 创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库。
 *          2、管理事务
 *              开启事务： void setAutoCommit(boolean autoCommit) 调用该方法设置参数为false，即开启事务
 *              提交事务： void commit() 提交事务
 *              回滚事务： void rollback() 回滚事务
 * 3、Statement：执行sql对象
 *      1、执行sql
 *          boolean execute(String sql)：可以执行任意的sql 了解即可
 *          int executeUpdate(String sql)：执行DML(INSERT、UPDATE、DELETE)语句、DDL(CREATE,ALTER,DROP)语句
 *              返回值：影响的行数，通过影响行数判断DML语句是否执行成功，返回值>0执行成功，反之失败
 *          ResultSet executeUpdate(String sql)：执行DQL(SELECT)语句
 * 4、ResultSet：结果集对象，封装查询结果
 *       boolean next() 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，如果没有数据，返回false，如果有数据，返回true。
 *       getXxx(参数); 获取数据
 *           Xxx：代表数据类型，入：int getInt(); String getString();
 *           参数：
 *               1、int：代表列的编号，从1开始。如：getString(1);
 *               2、String：代表列的名称。如getDouble("balance");
 *       使用步骤：
 *           1、游标向下移动一行
 *           2、判断是否有数据
 *           3、获取数据
 * 5、PreparedStatement：执行sql对象      ***********************************IMPORTANT***************************************
 *       1、SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全性问题
 *           输入用户名随便，输入密码：a' or 'a' = 'a
 *           sql：select * from user where username = 'XXXXXXXX' and password = 'a' or 'a' = 'a'
 *       2、解决SQL注入问题：使用preparedStatement对象来解决
 *           java.sql public interface PreparedStatement extends Statement 表示预编译的 SQL 语句的对象。
 *       3、预编译的SQL：参数使用 ? 作为占位符
 *       步骤：
 *          1、导入驱动jar包 mysql-connector-java-8.0.21.jar
 *          2、注册驱动
 *          3、获取数据库连接对象Connection
 *          4、定义sql
 *              注意：sql参数使用?作为占位符。select * from user where username = ? and password = ?;
 *          5、获取执行sql语句的对象PreparedStatement
 *              PreparedStatement prepareStatement(String sql)
 *          6、给?赋值
 *              方法：setXxx(参数1，参数2)
 *                  参数1：?的位置，从1开始
 *                  参数2：?的值
 *          7、执行sql，接受返回结果，不需要传递参数sql语句
 *          8、处理对象
 *          9、释放资源
 * 6、注意：后期都会使用PreparedStatement对象来完成增删改查的所有操作
 *      1、可以防止SQL注入
 *      2、效率更高
 * */
public class Demo01Jdbc {
    public static void main(String[] args) throws Exception {
        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");      //mysql8.0+
        //Class.forName("com.mysql.jdbc.Driver");    //mysql5.0+

        //3、获取数据库连接对象Connection
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?useSSL=false&serverTimezone=UTC", "root", "root");   //mysql8.0+
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false&serverTimezone=UTC", "root", "root"); //简写，三个///
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");       //mysql5.0+

        //4、定义sql语句
        String sql = "update account set balance = 2000 where id = 1";
        //5、获取执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        //6、执行sql，接收返回结果
        int count = stmt.executeUpdate(sql);
        //7、处理结果
        System.out.println(count);
        //8、释放资源
        stmt.close();
        conn.close();
    }
}
