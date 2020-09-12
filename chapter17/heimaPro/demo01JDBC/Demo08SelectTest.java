package chapter17.heimaPro.demo01JDBC;

import chapter17.heimaPro.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 练习：定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回
 * 1、定义EMP类
 * 2、定义方法public List<Emp> findAll(){}
 * 3、实现方法 select * from emp;
 * */
public class Demo08SelectTest {

    public static void main(String[] args) {
        List<Emp> list = new Demo08SelectTest().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 查询所有Emp对象
     * @return emp结果列表
     * */
    public List<Emp> findAll() {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db2?useSSL=false&serverTimezone=UTC", "root", "root");
            //3、定义sql
            String sql = "select * from emp";
            //4、获取执行sql的对象
            stmt = conn.createStatement();
            //5、执行sql
            rs = stmt.executeQuery(sql);
            //6、遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()) {
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //避免出现空指针异常
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return list;
    }
}
