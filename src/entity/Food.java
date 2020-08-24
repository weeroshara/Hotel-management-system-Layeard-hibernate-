package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food implements  SupperEntity{
    @Id
    private String foodId;
    private String foodName;
    private BigDecimal price;
    private int puentityOnHand;

    /*public Food() {
    }

    public Food(String foodId, String foodName, BigDecimal price, int puentityOnHand) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.puentityOnHand = puentityOnHand;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPuentityOnHand() {
        return puentityOnHand;
    }

    public void setPuentityOnHand(int puentityOnHand) {
        this.puentityOnHand = puentityOnHand;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId='" + foodId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", puentityOnHand=" + puentityOnHand +
                '}';
    }*/
}
