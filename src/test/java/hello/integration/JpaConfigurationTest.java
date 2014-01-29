package hello.integration;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Xiaohu on 14-1-28.
 */
@ContextConfiguration("/applicationContext.xml")
public class JpaConfigurationTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Test
    public void testJpaConfiguration() {
        Assert.assertNotNull(entityManagerFactory);

    }
}
