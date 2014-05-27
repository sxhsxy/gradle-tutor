package hello.integration;

import hello.domain.Permission;
import hello.domain.Role;
import hello.domain.User;
import hello.repository.PermissionRepository;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaohu on 14-5-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AuthorizationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTest.class);


    @Test
    public void testManyToMany() {
        logger.debug("save new permission 'user:view'.");
        Permission permission = permissionRepository.save(new Permission("user:view"));
        logger.debug("save new role 'Administrator'.");
        Role role = roleRepository.save(new Role("Administrator"));
        logger.debug("get role's permission set.");
        Set<Permission> permissions = role.getPermissions();
        logger.debug("add permission to permission set.");
        permissions.add(permission);
        logger.debug("save the role.");
        roleRepository.save(role);
        //给role添加permission
        Permission p1 = permissionRepository.save(new Permission("user:edit"));
        logger.debug("findByName 'Administrator'.");
        Role role1 = roleRepository.findByName("Administrator");
        if(role1 != null) {
            logger.debug("Hibernate.initialize().");
            Hibernate.initialize(role1.getPermissions());
            logger.debug("role1.getPermissions().");
            Set<Permission> permissions1= role1.getPermissions();
            logger.debug("permission1.add(p1).");
            permissions1.add(p1);
            //role1.setPermissions(permissions1);

        }
        roleRepository.save(role1);
        //Add a new user with role "Administrator"
        User user = new User("sxhsxy", "123456", "小虎");
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName("Administrator"));
        user.setRoles(roles);
        System.out.println(user);

    }
}
