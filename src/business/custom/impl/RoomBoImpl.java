package business.custom.impl;

import business.custom.RoomBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.RoomDAO;
import db.HibernateUtil;
import entity.Food;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.RoomTM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBO {

    private RoomDAO roomDAO= DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public List<RoomTM> findAllRooms() throws Exception{
        Session session = HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        List<RoomTM> roomTMS=new ArrayList<>();
        try {
            tx=session.beginTransaction();

            List<Room> allRooms = roomDAO.findAll();
            for (Room allRoom : allRooms) {
                roomTMS.add(new RoomTM(allRoom.getRoomId(),allRoom.getCategory(),
                        allRoom.getPrice(),allRoom.getNumberOfBeds()));
            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

        return roomTMS;
    }

    @Override
    public RoomTM findRoom(String id) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        RoomTM roomTM=null;
        try {
            tx=session.beginTransaction();

            Room room = roomDAO.find(id);
            roomTM = new RoomTM(room.getRoomId(), room.getCategory(), room.getPrice(), room.getNumberOfBeds());

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

        return roomTM;
    }

    @Override
    public void saveRooms(String roomId, String category, BigDecimal price, int noFoBeds) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            roomDAO.save(new Room(roomId,category,price,noFoBeds,0));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public void updateRoom(String roomId, String category, BigDecimal price, int noFoBeds) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            roomDAO.update(new Room(roomId,category,price,noFoBeds,0));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }


    }

    @Override
    public void deleteRoom(String id) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        roomDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            roomDAO.delete(id);

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }



    }


}
