package business.custom;

import business.SuperBO;
import util.RoomTM;

import java.math.BigDecimal;
import java.util.List;

public interface RoomBO extends SuperBO {
    public List<RoomTM> findAllRooms() throws Exception;
    public RoomTM findRoom(String id)throws Exception;
    public boolean saveRooms(String roomId, String category , BigDecimal price, int noFoBeds) throws Exception;
    public boolean updateRoom(String roomId, String category , BigDecimal price, int noFoBeds) throws Exception;
    public boolean deleteRoom(String id) throws Exception;

}
