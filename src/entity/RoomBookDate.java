package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomBookDate implements  SupperEntity{
    @EmbeddedId
    private RoomBookDatePK roomBookDatePK;
    private Date bookingDate;

    @OneToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "nic",insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "roomId",insertable = false, updatable = false)
    private Room rooml;

    public RoomBookDate(RoomBookDatePK roomBookDatePK, Date bookingDate) {
        this.roomBookDatePK = roomBookDatePK;
        this.bookingDate = bookingDate;
    }

    public RoomBookDate(String roomId, String customerId, Date bookingDate) {
        this.roomBookDatePK = new RoomBookDatePK(roomId, customerId);
        this.bookingDate = bookingDate;
    }



    // automa meka venawada me pta oe eka nisa?

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }









    //    public RoomBookDate() {
//    }
//
//    public RoomBookDate(RoomBookDatePK roomBookDatePK, Date bookingDate) {
//        this.roomBookDatePK = roomBookDatePK;
//        this.bookingDate = bookingDate;
//    }
//    public RoomBookDate(String roomId, String customerId, Date bookingDate) {
//        this.roomBookDatePK = new RoomBookDatePK(roomId,customerId);
//        this.bookingDate = bookingDate;
//    }
//
//    public Date getBookingDate() {
//        return bookingDate;
//    }
//
//    public void setBookingDate(Date bookingDate) {
//        this.bookingDate = bookingDate;
//    }
//
//    public RoomBookDatePK getRoomBookDatePK() {
//        return roomBookDatePK;
//    }
//
//    public void setRoomBookDatePK(RoomBookDatePK roomBookDatePK) {
//        this.roomBookDatePK = roomBookDatePK;
//    }
//
//    @Override
//    public String toString() {
//        return "RoomBookDate{" +
//                ", bookingDate=" + bookingDate +
//                '}';
//    }
}
