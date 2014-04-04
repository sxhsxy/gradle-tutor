package hello.integration;

import hello.domain.User;
import hello.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Xiaohu on 14-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SpringDataJpaTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void prepareData() {
        this.deleteAllEntities();
        this.insertSomeRecords();
    }

    @Test
    public void testJpaDao() {
        System.out.println("记录总数： " + userRepository.count());
        for(User u : userRepository.findAll()) {
            System.out.println(u);
        }
        PageRequest pageRequest = new PageRequest(38, 10);
        Page<User> userPage = userRepository.findAll(pageRequest);
        System.out.println("第 " + userPage.getNumber() + " 页");
        System.out.println("每页包含 " + userPage.getSize() + " 条记录");
        System.out.println("内容为：");
        for(User u : userPage.getContent()) {
            System.out.println(u);
        }
    }

    public void insertSomeRecords() {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/xiaohudb";
            con = DriverManager.getConnection(url, "xiaohu", "123456");

            String sql = "insert into sys_user(login_name, password, name) values (?, ?, ?)";
            pst = con.prepareStatement(sql);
            for(int x = 0; x < 100; x++){
                pst.setString(1, "user"+x);
                pst.setString(2, "psw");
                pst.setString(3, "用户"+x);
                pst.addBatch();
            }
            pst.executeBatch();



            /*pst.setString(1, "张三");  //也可以用setObject()
            pst.setString(2, "123");
            pst.addBatch();

            pst.setString(1, "李四");
            pst.setString(2, "456");
            pst.addBatch();

            pst.executeBatch();*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                    pst = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAllEntities() {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/xiaohudb";
            con = DriverManager.getConnection(url, "xiaohu", "123456");

            String sql = "delete from sys_user";
            pst = con.prepareStatement(sql);
            pst.execute();



            /*pst.setString(1, "张三");  //也可以用setObject()
            pst.setString(2, "123");
            pst.addBatch();

            pst.setString(1, "李四");
            pst.setString(2, "456");
            pst.addBatch();

            pst.executeBatch();*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                    pst = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
