package entity;

public class RoomBookDatePK implements SupperEntity{
    private String roomId;
    private String customerId;

    public RoomBookDatePK() {
    }

    public RoomBookDatePK(String roomId, String customerId) {
        this.roomId = roomId;
        this.customerId = customerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RoomBookDatePK{" +
                "roomId='" + roomId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
