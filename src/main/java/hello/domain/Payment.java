package hello.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xiaohu on 2015/3/6.
 */
@Entity
@Table(name = "wms_payment", schema = "", catalog = "xiaohudb")
public class Payment {
    private Long id;
    private Purchase purchase;
    private Timestamp paymentTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (createTime != null ? !createTime.equals(payment.createTime) : payment.createTime != null) return false;
        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (paymentTime != null ? !paymentTime.equals(payment.paymentTime) : payment.paymentTime != null) return false;
        if (purchase != null ? !purchase.equals(payment.purchase) : payment.purchase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (purchase != null ? purchase.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id", nullable = false)
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT+8")
    @Basic
    @Column(name = "payment_time")
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
