package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderFoodDAO;
import entity.OrderFood;
import org.hibernate.Session;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.sql.ResultSet;
import java.util.List;

public class OrderFoodDAOImpl implements OrderFoodDAO {

    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<OrderFood> findAll() {
        return null;
    }

    @Override
    public OrderFood find(String key) {
        return null;
    }

    @Override
    public void save(OrderFood entity) {
         CrudUtil.execute("INSERT INTO OrderFood VALUES (?,?,?,?)", entity.getOrderId(),entity.getCustomer(),
                entity.getTime(),entity.getDeleverDate());
    }

    @Override
    public void update(OrderFood entity) {

    }

    @Override
    public void delete(String key) {

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
