package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderFoodItemDAO;
import entity.OrderFoodItem;
import entity.OrderFoodItemPK;
import org.hibernate.Session;

import java.util.List;

public class OrderFoodItemDAOImpl implements OrderFoodItemDAO {

    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<OrderFoodItem> findAll() {
        return null;
    }

    @Override
    public OrderFoodItem find(OrderFoodItemPK key) {
        return null;
    }

    @Override
    public void save(OrderFoodItem entity) {
         CrudUtil.execute("INSERT INTO OrderFoodItem VALUES (?,?,?,?)",entity.getOrderFoodItemPK().getOrderId(),
                entity.getOrderFoodItemPK().getFoodId(),entity.getFoodName(),entity.getQuentity());
    }

    @Override
    public void update(OrderFoodItem entity) {
    }

    @Override
    public void delete(OrderFoodItemPK key) {

    }
}
