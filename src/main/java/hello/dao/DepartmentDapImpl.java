package hello.dao;

import hello.domain.Department;
import hello.domain.User;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by xiaohu on 14-3-8.
 */
public class DepartmentDapImpl extends JpaDao<Department,Integer> implements DepartmentDao {
    public boolean removeDepartment(Department department) {
        Query departmentUsersQuery = entityManager.createQuery("select u from User u where u.id = :departId");
        departmentUsersQuery.setParameter("departId", department.getId());
        List<User> result=(List<User>)departmentUsersQuery.getResultList();
        if(result.isEmpty()) {
            return false;
        };
        remove(department);
        return true;
    }
}
