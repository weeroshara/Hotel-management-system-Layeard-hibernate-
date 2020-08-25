package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RoomBookDateDAO;
import entity.RoomBookDate;
import entity.RoomBookDatePK;
import org.hibernate.Session;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomBookDateDAOImpl implements RoomBookDateDAO {


    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<RoomBookDate> findAll() throws Exception{
       return session.createQuery("FROM entity.RoomBookDate").list();

    }

    @Override
    public RoomBookDate find(RoomBookDatePK key) throws Exception{
        return session.get(RoomBookDate.class,key);
    }

    @Override
    public void save(RoomBookDate roomBookDate) throws Exception{
       session.save(roomBookDate);
    }

    @Override
    public void update(RoomBookDate roomBookDate) throws Exception{
       session.update(roomBookDate);
    }

    @Override
    public void delete(RoomBookDatePK key) throws Exception{
        session.delete(key);
    }

}
