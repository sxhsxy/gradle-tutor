package hello.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Xiaohu on 14-1-29.
 */
@Transactional
abstract class JpaDao<E, K extends Serializable> implements GenericDao<E, K> {
    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<? extends E> daoType;
    public JpaDao() {
        daoType = (Class<E>) ((ParameterizedType) (getClass().getGenericSuperclass()))
                .getActualTypeArguments()[0];
    }
    public void add(E entity) {
        entityManager.persist(entity);
    }


    public void update(E entity) {
        entityManager.merge(entity);
    }


    public void remove(E entity) {
        entityManager.remove(entity);
    }


    public E find(K key) {
        return entityManager.find(daoType, key);
    }


    public List<E> list() {
        System.out.println(daoType.getSimpleName());
        System.out.println(entityManager.toString());
        Query query = entityManager.createQuery("select h from " + daoType.getSimpleName() + " h");
        return query.getResultList();
    }
}
