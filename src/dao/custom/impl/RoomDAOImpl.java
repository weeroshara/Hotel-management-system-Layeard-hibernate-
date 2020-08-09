package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RoomDAO;
import entity.Room;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> findAll() throws Exception{
            ResultSet resultSet = CrudUtil.execute("SELECT *FROM Room");
            List<Room> rooms=new ArrayList<>();
            while (resultSet.next()){
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(resultSet.getString(3)));
                int bedCount = Integer.parseInt(resultSet.getString(4));
                rooms.add(new Room(resultSet.getString(1),resultSet.getString(2), price,bedCount,
                        resultSet.getInt(5)));
            }
            return rooms;

    }

    @Override
    public Room find(String key) throws Exception{
        ResultSet resultSet = CrudUtil.execute("SELECT *FROM Room WHERE roomId=?", key);
        if (resultSet.next()){
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(resultSet.getString(3)));
            int bedCount = Integer.parseInt(resultSet.getString(4));
            return new Room(resultSet.getString(1),resultSet.getString(2),price,bedCount,resultSet.getInt(5));
        }
        return null;

    }

    @Override
    public boolean save(Room entity) {
        return CrudUtil.execute("INSERT INTO Room VALUES (?,?,?,?,?)",entity.getRoomId(),
                entity.getCategory(),entity.getPrice(),entity.getNumberOfBeds(),entity.getIsBook());
    }

    @Override
    public boolean update(Room entity) {
        return CrudUtil.execute("UPDATE Room SET category=?, price=?, numberOfBeds=?, isBook=? WHERE roomId=?",
                entity.getCategory(), entity.getPrice(), entity.getNumberOfBeds(),
                entity.getIsBook(), entity.getRoomId());
    }

    @Override
    public boolean delete(String key) {
        return CrudUtil.execute("DELETE FROM Room WHERE roomId=?",key);
    }

    @Override
    public List<Room> acRoom(String category) throws Exception{
            ResultSet resultSet = CrudUtil.execute("SELECT roomId FROM Room WHERE category=? AND isBook=?", category,0);
            List<Room> rooms=new ArrayList<>();
            while (resultSet.next()){
                rooms.add(new Room(resultSet.getString(1),"",null,0,0));
            }
            return rooms;

    }

    @Override
    public boolean updateIsBook(String id, int isBook) throws Exception {
        return CrudUtil.execute("UPDATE Room SET isBook=? WHERE roomId=?",isBook,id);
    }
}
