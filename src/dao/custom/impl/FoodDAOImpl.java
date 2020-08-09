package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.FoodDAO;
import entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAOImpl implements FoodDAO {
    @Override
    public List<Food> findAll() {
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT *FROM Food");
            List<Food> foods=new ArrayList<>();
            while (resultSet.next()){
                foods.add(new Food(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getBigDecimal(3),resultSet.getInt(4)));
            }
            return foods;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Food find(String key) {
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT *FROM Food WHERE foodId=?", key);
            if (resultSet.next()){
                return new Food(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getBigDecimal(3),resultSet.getInt(4));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Food entity) {
        return CrudUtil.execute("INSERT INTO Food VALUES (?,?,?,?)",entity.getFoodId(),entity.getFoodName(),entity.getPrice(),entity.getPuentityOnHand());
    }

    @Override
    public boolean update(Food entity) {
        return CrudUtil.execute("UPDATE Food SET foodName=?, price=?, quentityOnHand=? WHERE foodId=?",entity.getFoodName(),entity.getPrice(),entity.getPuentityOnHand(), entity.getFoodId());
    }

    @Override
    public boolean delete(String key) {
        return CrudUtil.execute("DELETE FROM Food WHERE foodId=?",key);
    }

    @Override
    public List<Food> handOnFoods() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Food WHERE quentityOnHand!=?", 0);
        List<Food> foods=new ArrayList<>();
        while (resultSet.next()){
            foods.add(new Food(resultSet.getString(1),resultSet.getString(2),resultSet.getBigDecimal(3),resultSet.getInt(4)));
        }
        return foods;
    }

    @Override
    public boolean updateFoodCuentity(int quentity, String id) throws Exception {
        return CrudUtil.execute("UPDATE Food SET quentityOnHand=? WHERE foodId=?",quentity,id);
    }
}
