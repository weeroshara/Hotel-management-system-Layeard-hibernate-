package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.FoodDAO;
import entity.Food;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAOImpl implements FoodDAO {

    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<Food> findAll() {
        return session.createQuery("FROM entity.Food").list();
    }

    @Override
    public Food find(String key) {
        return session.get(Food.class,key);
    }

    @Override
    public void save(Food entity) {
        session.save(entity);
    }

    @Override
    public void update(Food entity) {
        session.update(entity);
    }

    @Override
    public void delete(String key) {
        session.delete(key);
    }

    @Override
    public List<Food> handOnFoods() throws Exception {
        return session.createNativeQuery("SELECT * FROM Food f WHERE quentityOnHand!=?1", Food.class)
                .setParameter(1, 1).list();

//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Food WHERE quentityOnHand!=?", 0);
//        List<Food> foods=new ArrayList<>();
//        while (resultSet.next()){
//            foods.add(new Food(resultSet.getString(1),resultSet.getString(2),resultSet.getBigDecimal(3),resultSet.getInt(4)));
//        }
//        return foods;
    }

    @Override
    public void updateFoodCuentity(int quentity, String id) throws Exception {
        session.createNativeQuery("UPDATE Food SET quentityOnHand=?1 WHERE foodId=?2")
                .setParameter(1,quentity)
                .setParameter(2,id).uniqueResult();
//         CrudUtil.execute("UPDATE Food SET quentityOnHand=? WHERE foodId=?",quentity,id);
    }
}
