package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RoomBookDateDAO;
import entity.RoomBookDate;
import entity.RoomBookDatePK;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomBookDateDAOImpl implements RoomBookDateDAO {
    @Override
    public List<RoomBookDate> findAll() throws Exception{
        ResultSet resultSet = CrudUtil.execute("SELECT *FROM RoomBookDate");
        List<RoomBookDate> roomBookDates=new ArrayList<>();
        while (resultSet.next()){
            roomBookDates.add(new RoomBookDate(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getDate(3)));
        }
        return roomBookDates;
    }

    @Override
    public RoomBookDate find(RoomBookDatePK key) throws Exception{
        return null;
    }

    @Override
    public boolean save(RoomBookDate entity) throws Exception{
        return CrudUtil.execute("INSERT INTO RoomBookDate VALUES (?,?,?)",entity.getRoomBookDatePK().getRoomId(),
                entity.getRoomBookDatePK().getCustomerId(),entity.getBookingDate());
    }

    @Override
    public boolean update(RoomBookDate entity) throws Exception{
        return false;
    }

    @Override
    public boolean delete(RoomBookDatePK key) throws Exception{
        return false;
    }

}
