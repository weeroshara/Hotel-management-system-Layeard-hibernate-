package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderFood implements  SupperEntity{
    @Id
    private String orderId;
    private String time;
    private Date deleverDate;

    //cascade eka depattatama dna one da?
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "nic")
    private Customer customer;


    /*public OrderFood() {
    }

    public OrderFood(String orderId, String customerId, String time, Date deleverDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.time = time;
        this.deleverDate = deleverDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDeleverDate() {
        return deleverDate;
    }

    public void setDeleverDate(Date deleverDate) {
        this.deleverDate = deleverDate;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", time='" + time + '\'' +
                ", deleverDate=" + deleverDate +
                '}';
    }*/
}
