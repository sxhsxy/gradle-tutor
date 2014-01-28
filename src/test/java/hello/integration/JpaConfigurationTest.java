package hello.integration;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Xiaohu on 14-1-28.
 */
@ContextConfiguration("/applicationContext.xml")
public class JpaConfigurationTest {
    private EntityManagerFactory entityManagerFactory;
    @Test
    public void testJpaConfiguration() {
        Assert.assertNotNull(entityManagerFactory);
    }
}
