package entity;

import java.sql.Date;

public class RoomBookDate implements  SupperEntity{
    private RoomBookDatePK roomBookDatePK;
    private Date bookingDate;

    public RoomBookDate() {
    }

    public RoomBookDate(RoomBookDatePK roomBookDatePK, Date bookingDate) {
        this.roomBookDatePK = roomBookDatePK;
        this.bookingDate = bookingDate;
    }
    public RoomBookDate(String roomId, String customerId, Date bookingDate) {
        this.roomBookDatePK = new RoomBookDatePK(roomId,customerId);
        this.bookingDate = bookingDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public RoomBookDatePK getRoomBookDatePK() {
        return roomBookDatePK;
    }

    public void setRoomBookDatePK(RoomBookDatePK roomBookDatePK) {
        this.roomBookDatePK = roomBookDatePK;
    }

    @Override
    public String toString() {
        return "RoomBookDate{" +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
