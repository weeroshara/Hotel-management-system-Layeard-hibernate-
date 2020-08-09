package util;

import java.math.BigDecimal;

public class RoomTM {
    private String roomId;
    private String category;
    private BigDecimal price;
    private int noOfBeds;

    public RoomTM() {
    }

    public RoomTM(String roomId, String category, BigDecimal price, int noOfBeds) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.noOfBeds = noOfBeds;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "roomId='" + roomId + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", noOfBeds=" + noOfBeds +
                '}';
    }
}
