package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<Room> findAll() throws Exception{
        return session.createQuery("FROM entity.Room").list();

    }

    @Override
    public Room find(String key) throws Exception{
        return session.get(Room.class,key);

    }

    @Override
    public void save(Room entity) {
       session.save(entity);
    }

    @Override
    public void update(Room entity) {
        session.update(entity);
    }

    @Override
    public void delete(String key) {
       session.delete(key);
    }

    @Override
    public List<Room> acRoom(String category) throws Exception{
//        List<Room> list = session.createNativeQuery("SELECT *FROM Room r WHERE category=?1 AND isBook=?2", Room.class)
//                .setParameter(1, category)
//                .setParameter(2, 0).list();

        List<Room> ac_room = session.createNativeQuery("SELECT *FROM Room r WHERE category=?1 AND isBook=?2", Room.class)
                .setParameter(1, category)
                .setParameter(2, 0).list();

        return ac_room;

    }

    @Override
    public void updateIsBook(String id, int isBook) throws Exception {
        session.createNativeQuery("UPDATE Room SET isBook=?1 WHERE roomId=?2")
                .setParameter(1,id)
                .setParameter(2,isBook).uniqueResult();
//        return CrudUtil.execute("UPDATE Room SET isBook=? WHERE roomId=?",isBook,id);
    }
}
