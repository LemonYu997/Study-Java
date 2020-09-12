//Spring提供的JDBC
package chapter17.heimaPro.demo05JDBCtemplate;

import chapter17.heimaPro.util.JDBCPoolUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Spring框架对JDBC的简单封装，提供了一个JDBCTemplate对象简化JDBC的开发
 *
 * 使用步骤：
 * 1、导入jar包 5个Spring包，1个连接池包，1个驱动包
 * 2、创建JDBCTemplate对象，依赖于数据源DataSource
 *      JdbcTemplate template = new JdbcTemplate(ds);
 * 3、调用JdbcTemplate的方法来完成CRUD的操作
 *      update()：执行DML语句。增、删、改
 *      queryForMap()：查询结果，将结果集封装为map集合
 *          注意：这个方法查询的结果集只能是1，将列名作为key，将值作为value，将这条记录封装为一个map集合
 *      queryForList()：查询结果，将结果集封装为list集合
 *          注意：将每一条记录封装为一个Map集合，再将Map集合装载到list集合中
 *      query()：查询结果，将结果封装为JavaBean对象
 *          query的参数：RowMapper
 *          一般使用BeanPropertyRowMapper实现类，可以完成数据到JavaBean的自动封装
 *          new BeanPropertyRowMapper<类型>(类型.class)
 *      queryForObject()：查询结果，将结果封装为对象
 *          一般用于聚合函数的查询
 * */
public class Demo01JDBCTemplate {
    public static void main(String[] args) {
        //1、导入jar包
        //2、创建JDBCTemplate
        JdbcTemplate template = new JdbcTemplate(JDBCPoolUtils.getDataSource());
        //3、定义sql
        String sql = "update account set balance = 2500 where id = ?";
        //4、调用方法
        int count = template.update(sql, 6);        //这里的3表示？的值是3
        System.out.println(count);
    }
}
