//使用JDBCTemplate执行DML和DQL语句
package chapter17.heimaPro.demo05JDBCtemplate;

import chapter17.heimaPro.domain.Emp;
import chapter17.heimaPro.util.JDBCPoolUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
 * 练习需求：操作对象为emp表
 * 1、修改1号数据的 salary 为 10000
 * 2、添加一条记录
 * 3、删除刚才添加的记录
 * 4、查询id为1的记录，将其封装为Map集合
 * 5、查询所有的记录，将其封装为List集合
 * 6、查询所有记录，将其封装为Emp对象的list集合
 * 7、查询总记录数
 * */
public class Demo02DmlTest {
    //Junit单元测试，可以让方法独立执行

    //1、获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCPoolUtils.getDataSource());

    /**
     * 1、修改1号数据的 salary 为 10000
     */
    @Test
    public void test1() {
        //2、定义sql
        String sql = "update emp set salary = 10000 where id = 1001";
        //3、执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2、添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp(id, ename, dept_id) values (?, ?, ?)";

        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /**
     * 3、删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     * 4、查询id为1的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集只能是1，将列名作为key，将值作为value，将这条记录封装为一个map集合
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}

        //如果用map封装两条记录，会封装失败
        //String sql = "select * from emp where id = ? or id = ?";
        //Map<String, Object> map = template.queryForMap(sql, 1001, 1002);
        //org.springframework.dao.IncorrectResultSizeDataAccessException: Incorrect result size: expected 1, actual 2
    }

    /**
     * 5、查询所有的记录，将其封装为List集合
     * 注意：将每一条记录封装为一个Map集合，再将Map集合装载到list集合中
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6、查询所有记录，将其封装为Emp对象的list集合（实际常用）
     * 自己实现RowMapper
     */
    @Test
    public void test6_1() {
        String sql = "select * from emp";
        //匿名内部类实现RowMapper接口
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 6、查询所有记录，将其封装为Emp对象的list集合（实际常用）
     * 默认方式
     */
    @Test
    public void test6_2() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        //Failed to convert property value of type 'null' to required type 'double' for property 'bonus
        //可以Emp中的基本类型改为引用封装类型
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7、查询总记录数
     */
    @Test
    public void test7() {
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
