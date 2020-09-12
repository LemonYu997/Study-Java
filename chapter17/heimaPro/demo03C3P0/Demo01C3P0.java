//数据库连接池
package chapter17.heimaPro.demo03C3P0;

/*
 * 数据库连接池：就是一个容器(集合)，存放数据库连接的容器。
 * 当系统初始化好后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完后，会将连接对象归还给容器。
 *
 * 优点：
 * 1、节约资源
 * 2、用户访问高效
 *
 * 实现：
 * 1、标准接口：DataSource javax.sql包下的
 *  方法：
 *      获取连接：Connection getConnection()
 *      归还连接：如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法，则不会再关闭连接了，而是归还连接
 * 2、一般不由我们实现，而由数据库厂商实现
 *  2.1 C3P0：数据库连接池实现技术
 *  2.2 Druid：数据库连接池实现技术，阿里巴巴提供
 *
 * C3P0使用步骤：
 * 1、导入jar包 c3p0-0.9.5.2.gar mchange-commons-java-0.2.12.gar
 * 2、不要忘记导入数据库的驱动jar包
 * 3、定义配置文件：
 *      名称：c3p0.properties 或者 c3p0-config.xml
 *      路径：直接将文件放在src目录下即可
 * 4、创建核心对象 数据库连接池对象 ComboPooledDataSource
 * 5、获取连接：getConnection
 * */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//C3P0的演示
public class Demo01C3P0 {
    public static void main(String[] args) throws SQLException {
        //1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2、获取连接对象
        Connection conn = ds.getConnection();
        //3、打印
        System.out.println(conn);
    }
}
