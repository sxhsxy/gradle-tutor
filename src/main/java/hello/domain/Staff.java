package hello.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by xiaohu on 2015/2/26.
 */
@Entity
@Table(name = "wms_staff", schema = "", catalog = "xiaohudb")
public class Staff {
    private Long id;
    private String name;
    private String phone;
    private Collection<Purchase> Purchases;
    private Collection<Sale> Sales;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "wms_staff",
            valueColumnName = "next_val"
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != null ? !id.equals(staff.id) : staff.id != null) return false;
        if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
        if (phone != null ? !phone.equals(staff.phone) : staff.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    public Collection<Purchase> getPurchases() {
        return Purchases;
    }

    public void setPurchases(Collection<Purchase> purchases) {
        Purchases = purchases;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    public Collection<Sale> getSales() {
        return Sales;
    }

    public void setSales(Collection<Sale> sales) {
        Sales = sales;
    }
}
