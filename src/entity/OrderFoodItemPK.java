package entity;

public class OrderFoodItemPK implements SupperEntity{
    private String orderId;
    private String foodId;

    public OrderFoodItemPK() {
    }

    public OrderFoodItemPK(String orderId, String foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return "OrderFoodItemPK{" +
                "orderId='" + orderId + '\'' +
                ", foodId='" + foodId + '\'' +
                '}';
    }
}
