package hello.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by xiaohu on 2015/2/26.
 */
@Entity
@Table(name = "wms_purchase", schema = "", catalog = "xiaohudb")
public class Purchase {
    private Long id;
    private Integer quantity;
    private Timestamp purchaseTime;
    private Timestamp createTime;
    private Commodity commodity;
    private Staff staff;
    private Supplier supplier;
    private hello.domain.Payment payment;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="hibernate_table_generator")
    @TableGenerator(name = "hibernate_table_generator",
            table = "hibernate_sequence_table",
            pkColumnName = "sequence_name",
            pkColumnValue = "wms_purchase",
            valueColumnName = "next_val"
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT+8")
    @Basic
    @Column(name = "purchase_time")
    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (createTime != null ? !createTime.equals(purchase.createTime) : purchase.createTime != null) return false;
        if (id != null ? !id.equals(purchase.id) : purchase.id != null) return false;
        if (purchaseTime != null ? !purchaseTime.equals(purchase.purchaseTime) : purchase.purchaseTime != null)
            return false;
        if (quantity != null ? !quantity.equals(purchase.quantity) : purchase.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (purchaseTime != null ? purchaseTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "commodity_id", referencedColumnName = "id", nullable = false)
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "purchase")
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
