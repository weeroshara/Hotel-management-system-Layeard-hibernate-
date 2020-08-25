package business.custom.impl;

import business.SuperBO;
import business.custom.BookingRoomBo;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomBookDateDAO;
import dao.custom.RoomDAO;
import db.DBConnection;
import db.HibernateUtil;
import entity.Room;
import entity.RoomBookDate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
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

        Session session=HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        List<String> roomId=new ArrayList<>();
        try {
            tx=session.beginTransaction();

            List<Room> rooms = roomDAO.acRoom(category);
            for (Room room : rooms) {
               roomId.add(room.getRoomId());
                System.out.println(room);
            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

       // return roomId.size()>0 ? roomId:null;
        return roomId;
        }

    @Override
    public void placeRoomOrder(String customerId, Date date, List<BookRoomTM> bookRoomTMS){

        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction tx=null;

        try {
            tx=session.beginTransaction();
            roomDAO.setSesion(session);
            roomBookDateDAO.setSesion(session);

//            for (BookRoomTM bookRoomTM : bookRoomTMS) {
//                roomDAO.updateIsBook(bookRoomTM.getRoomId(), 1);
//
//                roomBookDateDAO.save(new RoomBookDate(bookRoomTM.getRoomId(), customerId, date));
//            }
            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }



//        try {
//            connection.setAutoCommit(false);
//
//            for (BookRoomTM bookRoomTM : bookRoomTMS) {
//                boolean resultset = roomDAO.updateIsBook(bookRoomTM.getRoomId(), 1);
//
//                if (!resultset){
//                    connection.rollback();
//                    return false;
//                }
//
//                resultset = roomBookDateDAO.save(new RoomBookDate(bookRoomTM.getRoomId(), customerId, date));
//
//                if (!resultset){
//                    connection.rollback();
//                    return false;
//                }
//            }
//
//            connection.commit();
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            return false;
//        }finally {
//            try {
//                connection.setAutoCommit(true);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }


    }
}
