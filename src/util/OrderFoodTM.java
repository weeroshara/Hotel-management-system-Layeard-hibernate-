package util;

import java.math.BigDecimal;

public class OrderFoodTM {
    private String foodId;
    private String foodName;
    private int quentity;
    private BigDecimal total;

    public OrderFoodTM() {
    }

    public OrderFoodTM(String foodId, String foodName, int quentity, BigDecimal total) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.quentity = quentity;
        this.total = total;
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

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderFoodTM{" +
                "foodId='" + foodId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", quentity=" + quentity +
                ", total=" + total +
                '}';
    }
}
