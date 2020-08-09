package dao.custom;

import dao.CrudDAO;
import entity.OrderFood;

public interface OrderFoodDAO extends CrudDAO<OrderFood,String> {
    public String ordrId() throws Exception;
}
