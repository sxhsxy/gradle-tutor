package hello.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiaohu on 14-12-4.
 */
public class UserInfo {
    private Long id;     //在Persistence Entity中最好使用int，char等原始类型的包装类型，避免在spring mvc中由null值的String向这些原始类型转换失败而造成表单返回对象为null。
    @Column(name = "login_name")
    private String loginName;
    private String password;
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToMany
    @JoinTable(
            name = "sys_user_role",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();
}
