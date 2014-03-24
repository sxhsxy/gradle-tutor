package hello.integration;

import hello.domain.Department;
import hello.service.dao.DepartmentDapImpl;
import hello.service.dao.UserDao;
import hello.service.dao.UserDaoImpl;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;
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
import java.util.List;

/**
 * Created by Xiaohu on 14-1-28.
 */
@ContextConfiguration("/applicationContext.xml")
public class JpaConfigurationTest extends AbstractJUnit4SpringContextTests {
    @Autowired UserDao userDao;

    /*@Autowired private EntityManagerFactory entityManagerFactory;
       @PersistenceContext
    EntityManager em;

    @Test
    public void testJpaConfiguration() {
        Assert.assertNotNull(entityManagerFactory);
    }*/
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
}
