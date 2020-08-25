package business.custom.impl;

import business.custom.FoodBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.FoodDAO;
import db.HibernateUtil;
import entity.Customer;
import entity.Food;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FoodTM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodBOImpl implements FoodBO {
    FoodDAO foodDAO=DAOFactory.getInstance().getDAO(DAOType.FOOD);
    @Override
    public List<FoodTM> allFoods() throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        List<FoodTM> foodTMS=new ArrayList<>();
        try {
            tx=session.beginTransaction();

            List<Food> allFood = foodDAO.findAll();
            for (Food food : allFood) {
                foodTMS.add(new FoodTM(food.getFoodId(),food.getFoodName(),food.getPrice(),food.getPuentityOnHand()));
            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

        return foodTMS;
    }

    @Override
    public List<FoodTM> findPosibleFoods() throws Exception {

        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        List<FoodTM> foodTMS=new ArrayList<>();
        try {
            tx=session.beginTransaction();

            List<Food> foods = foodDAO.handOnFoods();
            for (Food food : foods) {
                foodTMS.add(new FoodTM(food.getFoodId(),food.getFoodName(),food.getPrice(),food.getPuentityOnHand()));
            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

        return foodTMS;

    }

    @Override
    public FoodTM findFood(String foodId) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        FoodTM foodTM=null;
        try {
            tx=session.beginTransaction();

            Food food = foodDAO.find(foodId);
            foodTM = new FoodTM(food.getFoodId(), food.getFoodName(), food.getPrice(), food.getPuentityOnHand());

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }
        return foodTM;
    }

    @Override
    public void saveFood(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            foodDAO.save(new Food(foodId,foodName,price,quentityOnHand));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public void updateFoods(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            foodDAO.update(new Food(foodId,foodName,price,quentityOnHand));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public void deletFood(String key) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        foodDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            foodDAO.delete(key);

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }


    }
}
