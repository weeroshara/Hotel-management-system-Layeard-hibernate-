package business;

import business.custom.impl.*;
import com.mysql.cj.xdevapi.RowImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }

    public <T extends SuperBO> T getBo(BOType boType){
        switch (boType){
            case ORDERFOOD:
                return (T) new OrderFoodBOImpl();
            case ROOM:
                return (T) new RoomBoImpl();
            case FOOD:
                return (T) new FoodBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case MANAGEPARK:
                return (T) new ManageParkBOImpl();
            case BOOKINGROOM:
                return (T) new BookingRoomBOImpl();
            default:
                return null;
        }
    }
}
