package business.custom.impl;

import business.SuperBO;
import business.custom.OrderFoodBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.FoodDAO;
import dao.custom.OrderFoodDAO;
import dao.custom.OrderFoodItemDAO;
import db.DBConnection;
import entity.OrderFood;
import entity.OrderFoodItem;
import util.OrderFoodTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderFoodBOImpl implements OrderFoodBO {

    private OrderFoodDAO orderFoodDAO= DAOFactory.getInstance().getDAO(DAOType.ORDERFOOD);
    private OrderFoodItemDAO orderFoodItemDAO=DAOFactory.getInstance().getDAO(DAOType.ORDERFOODITEM);
    private FoodDAO foodDAO=DAOFactory.getInstance().getDAO(DAOType.FOOD);

    @Override
    public String orderId() throws Exception {
        String s = orderFoodDAO.ordrId();
        if (s==null){
            return "OD001";
        }

        String newId="";
        int lastId = Integer.parseInt(s.replace("OD", ""));
        lastId=lastId+1;
        if (lastId<10){
            newId="OD00"+lastId;
        }else if (lastId<100){
            newId="OD0"+lastId;
        }else {
            newId="OD"+lastId;
        }
        return newId;
    }

    @Override
    public boolean placeOrderFood(String orderId, String customerId, List<OrderFoodTM> orderFoodTMS){
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean resultSet = orderFoodDAO.save(new OrderFood(orderId, customerId, LocalDate.now() + "", null));
            if (!resultSet){
                connection.rollback();
                return false;
            }

            for (OrderFoodTM orderFoodTM : orderFoodTMS) {
                resultSet = orderFoodItemDAO.save(new OrderFoodItem(orderId,orderFoodTM.getFoodId(),orderFoodTM.getFoodName(),orderFoodTM.getQuentity()));

                if (!resultSet){
                    connection.rollback();
                    return false;
                }


                resultSet= foodDAO.updateFoodCuentity(orderFoodTM.getQuentity(),orderFoodTM.getFoodId());
                if (!resultSet){
                    connection.rollback();
                    return false;
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
