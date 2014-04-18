package hello.domain;

import javax.persistence.*;

/**
 * Created by Xiaohu on 14-1-28.
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "dep_seq_generator")
    @SequenceGenerator(name = "dep_seq_generator",sequenceName = "department_id_seq")
    private Integer id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
