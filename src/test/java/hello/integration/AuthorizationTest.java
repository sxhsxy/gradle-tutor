package hello.integration;

import hello.domain.Permission;
import hello.domain.Role;
import hello.domain.User;
import hello.repository.PermissionRepository;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void testManyToMany() {
        Permission permission = permissionRepository.save(new Permission("user:view"));
        Role role = roleRepository.save(new Role("Administrator"));
        Set<Permission> permissions = role.getPermissions();
        permissions.add(permission);
        roleRepository.save(role);
        //给role添加permission
        Permission p1 = permissionRepository.save(new Permission("user:edit"));
        Role role1 = roleRepository.findByName("Administrator");
        if(role1 != null) {
            Set<Permission> permissions1= role1.getPermissions();
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
