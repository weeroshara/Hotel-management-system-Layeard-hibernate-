package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "orderFood")
public class Customer implements SupperEntity {
    @Id
    private String nic;
    private String name;
    private String phomeNumber;
    private int noOfMembors;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<OrderFood> orderFood;

    public Customer(String nic, String name, String phomeNumber, int noOfMembors, List<OrderFood> orderFood) {
        this.nic = nic;
        this.name = name;
        this.phomeNumber = phomeNumber;
        this.noOfMembors = noOfMembors;
        for (OrderFood food : orderFood) {
            food.setCustomer(this);
        }
        this.orderFood = orderFood;
    }

    public Customer(String nic, String name, String phomeNumber, int noOfMembors) {
        this.nic = nic;
        this.name = name;
        this.phomeNumber = phomeNumber;
        this.noOfMembors = noOfMembors;
    }

    public void setOrderFood(List<OrderFood> orderFood) {
        for (OrderFood food : orderFood) {
            food.setCustomer(this);
        }
        this.orderFood = orderFood;
    }

    public void addOrderFood(OrderFood orderFood) {
        orderFood.setCustomer(this);
        this.getOrderFood().add(orderFood);
    }



    /*public Customer() {
    }

    public Customer(String nic, String name, String phomeNumber, int noOfMembors) {
        this.nic = nic;
        this.name = name;
        this.phomeNumber = phomeNumber;
        this.noOfMembors = noOfMembors;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhomeNumber() {
        return phomeNumber;
    }

    public void setPhomeNumber(String phomeNumber) {
        this.phomeNumber = phomeNumber;
    }

    public int getNoOfMembors() {
        return noOfMembors;
    }

    public void setNoOfMembors(int noOfMembors) {
        this.noOfMembors = noOfMembors;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", phomeNumber='" + phomeNumber + '\'' +
                ", noOfMembors=" + noOfMembors +
                '}';
    }*/
}
