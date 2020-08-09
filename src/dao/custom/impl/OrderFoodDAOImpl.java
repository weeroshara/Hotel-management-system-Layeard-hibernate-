package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderFoodDAO;
import entity.OrderFood;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.sql.ResultSet;
import java.util.List;

public class OrderFoodDAOImpl implements OrderFoodDAO {
    @Override
    public List<OrderFood> findAll() {
        return null;
    }

    @Override
    public OrderFood find(String key) {
        return null;
    }

    @Override
    public boolean save(OrderFood entity) {
        return CrudUtil.execute("INSERT INTO OrderFood VALUES (?,?,?,?)", entity.getOrderId(),entity.getCustomerId(),
                entity.getTime(),entity.getDeleverDate());
    }

    @Override
    public boolean update(OrderFood entity) {
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public String ordrId() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT orderId FROM OrderFood ORDER BY orderId DESC LIMIT 1");
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
