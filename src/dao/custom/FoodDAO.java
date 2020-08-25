package dao.custom;

import dao.CrudDAO;
import entity.Food;

import java.util.List;

public interface FoodDAO extends CrudDAO<Food,String> {
    public List<Food> handOnFoods() throws Exception;
    public void updateFoodCuentity(int quentity, String id) throws Exception;
}
