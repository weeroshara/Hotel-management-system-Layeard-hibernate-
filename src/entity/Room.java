package entity;

import java.math.BigDecimal;

public class Room implements  SupperEntity{
    private String roomId;
    private String category;
    private BigDecimal price;
    private int numberOfBeds;
    private int isBook;

    public Room() {
    }


    public Room(String roomId, String category, BigDecimal price, int numberOfBeds, int isBook) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.isBook = isBook;
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

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getIsBook() {
        return isBook;
    }

    public void setIsBook(int isBook) {
        this.isBook = isBook;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", numberOfBeds=" + numberOfBeds +
                ", isBook=" + isBook +
                '}';
    }
}
