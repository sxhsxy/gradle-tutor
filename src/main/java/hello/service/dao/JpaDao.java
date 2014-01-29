package hello.service.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Xiaohu on 14-1-29.
 */
public class JpaDao<E, K> implements GenericDao<E, K> {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private Class<? extends E> daoType;

    public JpaDao() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void add(E entity) {

    }

    @Override
    public void update(E entity) {

    }

    @Override
    public void remove(E entity) {

    }

    @Override
    public E find(K key) {
        return null;
    }

    @Override
    public List<E> list() {
        return null;
    }
}
