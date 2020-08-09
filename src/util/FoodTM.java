package util;

import java.math.BigDecimal;

public class FoodTM {
    private String foodId;
    private String foodName;
    private BigDecimal price;
    private int quentityOnHand;

    public FoodTM() {
    }

    public FoodTM(String foodId, String foodName, BigDecimal price, int quentityOnHand) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.quentityOnHand = quentityOnHand;
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

    public int getQuentityOnHand() {
        return quentityOnHand;
    }

    public void setQuentityOnHand(int quentityOnHand) {
        this.quentityOnHand = quentityOnHand;
    }

    @Override
    public String toString() {
        return "FoodTM{" +
                "foodId='" + foodId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                ", quentityOnHand=" + quentityOnHand +
                '}';
    }
}
