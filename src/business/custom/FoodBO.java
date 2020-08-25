package business.custom;

import business.SuperBO;
import util.FoodTM;

import java.math.BigDecimal;
import java.util.List;

public interface FoodBO extends SuperBO {
    public List<FoodTM> allFoods() throws Exception;
    public List<FoodTM> findPosibleFoods() throws Exception;
    public FoodTM findFood(String foodId) throws Exception;
    public void saveFood(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception;
    public void updateFoods(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception;
    public void deletFood(String key) throws Exception;

}
