package business.custom.impl;

import business.SuperBO;
import business.custom.BookingRoomBo;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomBookDateDAO;
import dao.custom.RoomDAO;
import db.DBConnection;
import entity.Room;
import entity.RoomBookDate;
import util.BookRoomTM;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRoomBOImpl implements BookingRoomBo {

    RoomDAO roomDAO= DAOFactory.getInstance().getDAO(DAOType.ROOM);
    RoomBookDateDAO roomBookDateDAO=DAOFactory.getInstance().getDAO(DAOType.ROOMBOOK);

    @Override
    public List<String> acRoomOrNon(String category) throws Exception {
        List<Room> rooms = roomDAO.acRoom(category);
        List<String> roomId=new ArrayList<>();
        for (Room room : rooms) {
            roomId.add(new String(room.getRoomId()));
        }
        return roomId;
    }

    @Override
    public boolean placeRoomOrder(String customerId, Date date, List<BookRoomTM> bookRoomTMS){
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            for (BookRoomTM bookRoomTM : bookRoomTMS) {
                boolean resultset = roomDAO.updateIsBook(bookRoomTM.getRoomId(), 1);

                if (!resultset){
                    connection.rollback();
                    return false;
                }

                resultset = roomBookDateDAO.save(new RoomBookDate(bookRoomTM.getRoomId(), customerId, date));

                if (!resultset){
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
