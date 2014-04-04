package hello.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;
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
        entity = entityManager.merge(entity);
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

    /**
     * 获取实体工厂管理对象
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * 获取 Session
     */
    public Session getSession(){
        return (Session) getEntityManager().getDelegate();
    }

    /**
     * 强制与数据库同步
     */
    public void flush(){
        getSession().flush();
    }

    /**
     * 清除缓存数据
     */
    public void clear(){
        getSession().clear();
    }

    public DetachedCriteria createDetachedCriteria(Criterion... criterions) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(daoType);
        for(Criterion criterion : criterions) {
            detachedCriteria.add(criterion);
        }
        return detachedCriteria;
    }
}
