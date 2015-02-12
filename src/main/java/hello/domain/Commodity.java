package hello.domain;

import javax.persistence.*;

/**
 * Created by Xiaohu on 2015/2/11.
 */
@Entity
public class Commodity {
    private Long id;
    private String name;
    private String unit;
    private String serialNumber;
    private String typeNumber;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "commodity",
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
    @Column(name = "serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
        if (serialNumber != null ? !serialNumber.equals(commodity.serialNumber) : commodity.serialNumber != null)
            return false;
        if (typeNumber != null ? !typeNumber.equals(commodity.typeNumber) : commodity.typeNumber != null) return false;
        if (unit != null ? !unit.equals(commodity.unit) : commodity.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (typeNumber != null ? typeNumber.hashCode() : 0);
        return result;
    }
}
