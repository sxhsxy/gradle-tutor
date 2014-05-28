package hello.integration;

import hello.domain.Permission;
import hello.domain.Role;
import hello.domain.User;
import hello.repository.PermissionRepository;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;
import hello.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.shiro.mgt.SecurityManager;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaohu on 14-5-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/applicationContext.xml", "/applicationContext-shiro-test.xml"})
public class AuthorizationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private SystemService systemService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private SecurityManager securityManager;

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationTest.class);



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
        Role role1 = systemService.findRoleByNameEager("Administrator");
        if(role1 != null) {
            logger.debug("role1.getPermissions().");
            Set<Permission> permissions1= role1.getPermissions();
            logger.debug("permission1.add(p1).");
            permissions1.add(p1);
            //role1.setPermissions(permissions1);
            roleRepository.save(role1);
        }

        //Add a new user with role "Administrator"
        User user = new User("sxhsxy", "123456", "小虎");
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName("Administrator"));
        user.setRoles(roles);
        String hashedPassword = passwordService.encryptPassword(user.getPassword());
        user.setPassword(hashedPassword);
        systemService.saveUser(user);
        System.out.println(user);

    }

    @Test
    public void testAuthorization() {
        testManyToMany();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(new UsernamePasswordToken("sxhsxy", "123456"));
        currentUser.checkPermission("user:view");
    }
}
