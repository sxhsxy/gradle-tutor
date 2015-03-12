package hello.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xiaohu on 2015/3/6.
 */
@Entity
@Table(name = "wms_receipt", schema = "", catalog = "xiaohudb")
public class Receipt {
    private Long id;
    private Timestamp receiptTime;
    private Timestamp createTime;
    private hello.domain.Sale sale;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT+8")
    @Basic
    @Column(name = "receipt_time")
    public Timestamp getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Timestamp receiptTime) {
        this.receiptTime = receiptTime;
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

        Receipt receipt = (Receipt) o;

        if (createTime != null ? !createTime.equals(receipt.createTime) : receipt.createTime != null) return false;
        if (id != null ? !id.equals(receipt.id) : receipt.id != null) return false;
        if (receiptTime != null ? !receiptTime.equals(receipt.receiptTime) : receipt.receiptTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (receiptTime != null ? receiptTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id", nullable = false)
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
