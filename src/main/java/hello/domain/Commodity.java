package hello.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Xiaohu on 2015/2/11.
 */
@Entity
@Table(name = "wms_commodity", schema = "", catalog = "xiaohudb")
public class Commodity {
    private Long id;
    private String name;
    private String unit;
    private String typeNumber;
    private Collection<Purchase> Purchases;
    private Collection<Sale> Sales;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "wms_commodity",
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
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "type_number")
    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity commodity = (Commodity) o;

        if (id != null ? !id.equals(commodity.id) : commodity.id != null) return false;
        if (name != null ? !name.equals(commodity.name) : commodity.name != null) return false;

        if (typeNumber != null ? !typeNumber.equals(commodity.typeNumber) : commodity.typeNumber != null) return false;
        if (unit != null ? !unit.equals(commodity.unit) : commodity.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (typeNumber != null ? typeNumber.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "commodity")
    public Collection<Purchase> getPurchases() {
        return Purchases;
    }

    public void setPurchases(Collection<Purchase> purchases) {
        Purchases = purchases;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "commodity")
    public Collection<Sale> getSales() {
        return Sales;
    }

    public void setSales(Collection<Sale> sales) {
        Sales = sales;
    }
}
