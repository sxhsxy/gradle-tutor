package hello.service.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Xiaohu on 14-1-29.
 */
public class JpaDao<E, K> implements GenericDao<E, K> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<? extends E> daoType;

    public JpaDao() {
    }

    @Override
    public void add(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E find(K key) {
        return null;
    }

    @Override
    public List<E> list() {
        entityManager.createQuery("");
        return null;
    }
}
