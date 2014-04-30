package hello.domain;

import javax.persistence.*;

/**
 * Created by Xiaohu on 14-4-18.
 */
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "organization",
            valueColumnName = "next_val"
    )
    private Long id;
    private String name;
    private Long pId;
    private String type;

    public Organization() {
    }

    public Organization(String name, Long pId, String type) {
        this.name = name;
        this.pId = pId;
        this.type = type;
    }

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

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;

        Organization that = (Organization) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!pId.equals(that.pId)) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + pId.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", type='" + type + '\'' +
                '}';
    }
}
