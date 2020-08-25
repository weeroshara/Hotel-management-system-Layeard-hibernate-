package business.custom.impl;

import business.SuperBO;
import business.custom.OrderFoodBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.FoodDAO;
import dao.custom.OrderFoodDAO;
import dao.custom.OrderFoodItemDAO;
import db.DBConnection;
import db.HibernateUtil;
import entity.Food;
import entity.OrderFood;
import entity.OrderFoodItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FoodTM;
import util.OrderFoodTM;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderFoodBOImpl implements OrderFoodBO {

    private OrderFoodDAO orderFoodDAO= DAOFactory.getInstance().getDAO(DAOType.ORDERFOOD);
    private OrderFoodItemDAO orderFoodItemDAO=DAOFactory.getInstance().getDAO(DAOType.ORDERFOODITEM);
    private FoodDAO foodDAO=DAOFactory.getInstance().getDAO(DAOType.FOOD);

    @Override
    public String orderId() throws Exception {

        Session session = HibernateUtil.getSesionFactory().openSession();
        orderFoodDAO.setSesion(session);
        Transaction tx=null;

        String newId="";
        try {
            tx=session.beginTransaction();

            String s = orderFoodDAO.ordrId();
            if (s==null){
                return "OD001";
            }

            int lastId = Integer.parseInt(s.replace("OD", ""));
            lastId=lastId+1;
            if (lastId<10){
                newId="OD00"+lastId;
            }else if (lastId<100){
                newId="OD0"+lastId;
            }else {
                newId="OD"+lastId;
            }


            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }
        return newId;



    }

    @Override
    public void placeOrderFood(String orderId, String customerId, List<OrderFoodTM> orderFoodTMS){

        Session session = HibernateUtil.getSesionFactory().openSession();
        orderFoodDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            String now = LocalDate.now()+"";
            orderFoodDAO.save(new OrderFood(orderId, customerId, Date.valueOf(now), null));

            for (OrderFoodTM orderFoodTM : orderFoodTMS) {
                orderFoodItemDAO.save(new OrderFoodItem(orderId,orderFoodTM.getFoodId(),orderFoodTM.getFoodName(),orderFoodTM.getQuentity()));

                foodDAO.updateFoodCuentity(orderFoodTM.getQuentity(),orderFoodTM.getFoodId());

            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }


        /*try {
            connection.setAutoCommit(false);






        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/

    }
}
