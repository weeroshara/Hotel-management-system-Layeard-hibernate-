package business.custom.impl;

import business.custom.RoomBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomDAO;
import entity.Room;
import util.RoomTM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBO {

    private RoomDAO roomDAO= DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public List<RoomTM> findAllRooms() throws Exception{
        List<Room> allRooms = roomDAO.findAll();
        List<RoomTM> roomTMS=new ArrayList<>();
        for (Room allRoom : allRooms) {
            roomTMS.add(new RoomTM(allRoom.getRoomId(),allRoom.getCategory(),
                    allRoom.getPrice(),allRoom.getNumberOfBeds()));
        }
        return roomTMS;
    }

    @Override
    public RoomTM findRoom(String id) throws Exception {
        Room room = roomDAO.find(id);
        return new RoomTM(room.getRoomId(),room.getCategory(),room.getPrice(),room.getNumberOfBeds());
    }

    @Override
    public boolean saveRooms(String roomId, String category, BigDecimal price, int noFoBeds) throws Exception {
        return roomDAO.save(new Room(roomId,category,price,noFoBeds,0));
    }

    @Override
    public boolean updateRoom(String roomId, String category, BigDecimal price, int noFoBeds) throws Exception {
        return roomDAO.update(new Room(roomId,category,price,noFoBeds,0));
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDAO.delete(id);
    }


}
