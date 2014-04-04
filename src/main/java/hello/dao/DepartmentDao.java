package hello.dao;

import hello.domain.Department;

/**
 * Created by xiaohu on 14-3-8.
 */
public interface DepartmentDao extends GenericDao<Department,Integer> {
    public boolean removeDepartment(Department department);
}
