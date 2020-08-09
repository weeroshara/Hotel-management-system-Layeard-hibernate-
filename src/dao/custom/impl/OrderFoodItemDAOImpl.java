package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderFoodItemDAO;
import entity.OrderFoodItem;
import entity.OrderFoodItemPK;

import java.util.List;

public class OrderFoodItemDAOImpl implements OrderFoodItemDAO {
    @Override
    public List<OrderFoodItem> findAll() {
        return null;
    }

    @Override
    public OrderFoodItem find(OrderFoodItemPK key) {
        return null;
    }

    @Override
    public boolean save(OrderFoodItem entity) {
        return CrudUtil.execute("INSERT INTO OrderFoodItem VALUES (?,?,?,?)",entity.getOrderFoodItemPK().getOrderId(),
                entity.getOrderFoodItemPK().getFoodId(),entity.getFoodName(),entity.getQuentity());
    }

    @Override
    public boolean update(OrderFoodItem entity) {
        return false;
    }

    @Override
    public boolean delete(OrderFoodItemPK key) {
        return false;
    }
}
