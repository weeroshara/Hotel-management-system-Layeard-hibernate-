package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomEntity {
    private String customerId;
    private String customerName;
    private LocalDate date;
    private int noOfMembors;
    private String roomId;
    private String flow;

//    public CustomEntity() {
//    }
//
//
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public int getNoOfMembors() {
//        return noOfMembors;
//    }
//
//    public void setNoOfMembors(int noOfMembors) {
//        this.noOfMembors = noOfMembors;
//    }
//
//    public String getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(String roomId) {
//        this.roomId = roomId;
//    }
//
//    public String getFlow() {
//        return flow;
//    }
//
//    public void setFlow(String flow) {
//        this.flow = flow;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomEntity{" +
//                "customerId='" + customerId + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", date=" + date +
//                ", noOfMembors=" + noOfMembors +
//                ", roomId='" + roomId + '\'' +
//                ", flow='" + flow + '\'' +
//                '}';
//    }
}
