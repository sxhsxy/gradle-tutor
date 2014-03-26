package hello.integration;

import hello.domain.Department;
import hello.domain.User;
import hello.service.dao.DepartmentDapImpl;
import hello.service.dao.UserDao;
import hello.service.dao.UserDaoImpl;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Xiaohu on 14-1-28.
 */
@ContextConfiguration("/applicationContext.xml")
public class JpaConfigurationTest extends AbstractJUnit4SpringContextTests {
    @Autowired UserDao userDao;
    @PersistenceContext EntityManager em;

    /*@Autowired private EntityManagerFactory entityManagerFactory;
       @PersistenceContext
    EntityManager em;

    @Test
    public void testJpaConfiguration() {
        Assert.assertNotNull(entityManagerFactory);
    }*/
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

    @Test
    public void testJpaDao() {
        /* CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> cq = cb.createQuery(Department.class);
        Root<Department> dept = cq.from(Department.class);
        cq.select(dept);
        List<Department> list = em.createQuery(cq).getResultList();
        System.out.println(list);*/
        System.out.println(userDao.list());
        //System.out.println(new DepartmentDapImpl().list());
    }
    @Test
    public void testAdd() {
        int size = userDao.list().size();
        User user = new User();
        user.setLoginName("hhhhhh");
        user.setName("虎虎虎");
        user.setPassword("xxxxxx");
        userDao.add(user);

        // list should have one more User now
        assertTrue (size < userDao.list().size());
    }

    @Test
    public void testUpdate() {
        User user = new User("add", "新建用户", "xxxxxx");
        userDao.add(user);
        user.setLoginName("updated");
        user.setName("更新完成");

        userDao.update(user);
        User found = userDao.find(user.getId());
        assertEquals(user.getName(), found.getName());
        assertEquals(user.getLoginName(), found.getLoginName());
    }

    @Test
    public void testFind() {
        User user = new User("find", "find用户", "xxxxxx");
        userDao.add(user);

        User found = userDao.find(user.getId());
        assertEquals(found, user);
    }

    @Test
    public void testList() {
        assertEquals(0, userDao.list().size());

        List<User> users = Arrays.asList(
                new User("list1", "list用户1", "xxxxxx"),
                new User("list2", "list用户2", "xxxxxx"),
                new User("list3", "list用户3", "xxxxxx")
                );
        for (User user : users) {
            userDao.add(user);
        }

        List<User> found = userDao.list();
        assertEquals(3, found.size());
        for (User user : found) {
            assertTrue(users.contains(user));
        }
    }

    @Test
    public void testRemove() {
        User user = new User('test-User', 'hackzorz');
        userDao.add(user);

        // successfully added
        assertEquals(user, userDao.find(user.getId()));

        // try to remove
        userDao.remove(user);
        assertNull(userDao.find(user.getId()));
}
