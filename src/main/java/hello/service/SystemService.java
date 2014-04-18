package hello.service;

import hello.domain.Department;
import hello.domain.Organization;
import hello.domain.User;
import hello.repository.DepartmentRepository;
import hello.repository.OrganizationRepository;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Xiaohu on 14-4-2.
 */
@Service
@Transactional
public class SystemService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Page<User> findUser(PageRequest pageRequest, User user) {
        return userRepository.findAll(pageRequest);
    }

    public User findUser(Integer id) {
        return userRepository.findOne(id);
    }

    public void deleteUser(User user) {
       userRepository.delete(user);
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Page<Department> findDepartment(PageRequest pageRequest, Department department) {
        return departmentRepository.findAll(pageRequest);
    }

    public Department findDepartment(Integer id) {
        return departmentRepository.findOne(id);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.delete(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    public Page<Organization> findOrganization(PageRequest pageRequest, Organization organization) {
        return organizationRepository.findAll(pageRequest);
    }

    public Organization findOrganization(Integer id) {
        return organizationRepository.findOne(id);
    }

    public void deleteOrganization(Organization organization) {
        organizationRepository.delete(organization);
    }

    public void deleteOrganization(Integer id) {
        organizationRepository.delete(id);
    }

    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
}
