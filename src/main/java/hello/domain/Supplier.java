package hello.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by xiaohu on 2015/2/26.
 */
@Entity
@Table(name = "wms_supplier", schema = "", catalog = "xiaohudb")
public class Supplier {
    private Long id;
    private String name;
    private String liaison;
    private String phone;
    private Collection<Purchase> Purchases;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "wms_supplier",
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
    @Column(name = "liaison")
    public String getLiaison() {
        return liaison;
    }

    public void setLiaison(String liaison) {
        this.liaison = liaison;
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

        Supplier supplier = (Supplier) o;

        if (id != null ? !id.equals(supplier.id) : supplier.id != null) return false;
        if (liaison != null ? !liaison.equals(supplier.liaison) : supplier.liaison != null) return false;
        if (name != null ? !name.equals(supplier.name) : supplier.name != null) return false;
        if (phone != null ? !phone.equals(supplier.phone) : supplier.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (liaison != null ? liaison.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }


    @OneToMany(mappedBy = "supplier")
    public Collection<Purchase> getPurchases() {
        return Purchases;
    }

    public void setPurchases(Collection<Purchase> purchases) {
        Purchases = purchases;
    }
}
