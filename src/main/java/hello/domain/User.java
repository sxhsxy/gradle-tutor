package hello.domain;

import javax.persistence.*;

/**
 * Created by Xiaohu on 14-1-28.
 */

@Entity
@Table(name = "sys_user")
public class User {
    @Id
    @GeneratedValue(generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator", sequenceName = "sys_user_id_seq")
    private Integer id;     //在Persistence Entity中最好使用int，char等原始类型的包装类型，避免在spring mvc中由null值的String向这些原始类型转换失败而造成表单返回对象为null。
    @Column(name = "login_name")
    private String loginName;
    private String password;
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User() {
    }
    public User(String login_name, String password, String name) {
        this.loginName = login_name;
        this.password = password;
        this.name = name;

    }
    public User(String login_name, String password, String name, Department department) {
        this.loginName = login_name;
        this.password = password;
        this.name = name;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String login_name) {
        this.loginName = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (department != null ? !department.equals(user.department) : user.department != null) return false;
        if (!loginName.equals(user.loginName)) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + loginName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login_name='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
