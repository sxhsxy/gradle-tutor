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
    private int id;
    private int name;

    public Department(int name) {
        this.name = name;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (name != that.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name;
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
