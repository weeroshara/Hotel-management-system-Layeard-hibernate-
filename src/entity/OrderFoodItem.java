package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderFoodItem implements  SupperEntity{
    @EmbeddedId
    private OrderFoodItemPK orderFoodItemPK;
    private String foodName;
    private int quentity;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "orderFood_id", insertable = false, updatable = false)
    private OrderFood orderFood;

    public OrderFoodItem(OrderFoodItemPK orderFoodItemPK, String foodName, int quentity) {
        this.orderFoodItemPK = orderFoodItemPK;
        this.foodName = foodName;
        this.quentity = quentity;
    }

    public OrderFoodItem(String orderId, String foodId, String foodName, int quentity) {
        this.orderFoodItemPK = new OrderFoodItemPK(orderId,foodId);
        this.foodName = foodName;
        this.quentity = quentity;
    }


    //    public OrderFoodItem() {
//    }
//
//    public OrderFoodItem(OrderFoodItemPK orderFoodItemPK, String foodName, int quentity) {
//        this.orderFoodItemPK = orderFoodItemPK;
//        this.foodName = foodName;
//        this.quentity = quentity;
//    }
//
//    public OrderFoodItem(String orderId, String foodId, String foodName, int quentity) {
//        this.orderFoodItemPK = new OrderFoodItemPK(orderId,foodId);
//        this.foodName = foodName;
//        this.quentity = quentity;
//    }
//
//    public String getFoodName() {
//        return foodName;
//    }
//
//    public void setFoodName(String foodName) {
//        this.foodName = foodName;
//    }
//
//    public int getQuentity() {
//        return quentity;
//    }
//
//    public void setQuentity(int quentity) {
//        this.quentity = quentity;
//    }
//
//    public OrderFoodItemPK getOrderFoodItemPK() {
//        return orderFoodItemPK;
//    }
//
//    public void setOrderFoodItemPK(OrderFoodItemPK orderFoodItemPK) {
//        this.orderFoodItemPK = orderFoodItemPK;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderFoodItem{" +
//                ", foodName='" + foodName + '\'' +
//                ", quentity=" + quentity +
//                '}';
//    }
}
