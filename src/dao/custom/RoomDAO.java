package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    public List<Room> acRoom(String category) throws Exception;
    public void updateIsBook(String id, int isBook) throws Exception;
}