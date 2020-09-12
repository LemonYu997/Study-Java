//Druid数据库连接池
package chapter17.heimaPro.demo04Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
 * Druid：数据库连接池技术，阿里巴巴提供
 * 步骤：
 * 1、导入jar包 druid-1.0.9.jar
 * 2、定义配置文件
 *      是properties形式的
 *      可以叫任意名称，可以放在任意目录下
 * 3、加载配置文件 Properties
 * 4、获取数据库连接池对象：通过工厂类来获取 DruidDataSourceFactory
 * 5、获取连接：getConnection
 * */

/**
 * Druid演示
 * */
public class Demo01Druid {
    public static void main(String[] args) throws Exception {
        //1、导入jar包
        //2、定义配置文件
        //3、加载配置文件
        Properties pro = new Properties();
        InputStream is = Demo01Druid.class.getClassLoader().getResourceAsStream("chapter17/heimaPro/demo04Druid/druid.properties");
        pro.load(is);
        //4、获取链接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5、获取链接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
