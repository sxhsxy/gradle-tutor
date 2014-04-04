package hello.dao;

import java.util.List;

/**
 * Created by Xiaohu on 14-1-29.
 */
public interface GenericDao<E, K> {
    public void add(E entity);
    public void update(E entity);
    public void remove(E entity);
    public E find(K key);
    public List<E> list();
}
