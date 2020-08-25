package business.custom;

import business.SuperBO;
import util.BookRoomTM;
import java.sql.Date;
import java.util.List;

public interface BookingRoomBo extends SuperBO {
    public List<String> acRoomOrNon(String category) throws Exception;
    public void placeRoomOrder(String customerId, Date date, List<BookRoomTM> bookRoomTMS) throws Exception;


}
