package util;

import java.math.BigDecimal;

public class BookRoomTM {
    private String roomId;
    private BigDecimal price;
    private String category;


    public BookRoomTM() {
    }

    public BookRoomTM(String roomId, BigDecimal price, String category) {
        this.roomId = roomId;
        this.price = price;
        this.category = category;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookRoomTM{" +
                "roomId='" + roomId + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
