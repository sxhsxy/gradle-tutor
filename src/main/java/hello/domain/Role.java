package hello.domain;

import javax.persistence.*;

/**
 * Created by Xiaohu on 14-4-29.
 */
//@Entity
//@Table(name = "sys_role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            pkColumnValue = "sys_role"
    )
    //@SequenceGenerator(name = "user_seq_generator", sequenceName = "sys_user_id_seq")
    private Long id;     //在Persistence Entity中最好使用int，char等原始类型的包装类型，避免在spring mvc中由null值的String向这些原始类型转换失败而造成表单返回对象为null。
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (!id.equals(role.id)) return false;
        if (!name.equals(role.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
