package business.custom.impl;

import business.custom.FoodBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.FoodDAO;
import entity.Food;
import util.FoodTM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodBOImpl implements FoodBO {
    FoodDAO foodDAO=DAOFactory.getInstance().getDAO(DAOType.FOOD);
    @Override
    public List<FoodTM> allFoods() throws Exception {
        List<Food> allFood = foodDAO.findAll();
        List<FoodTM> foodTMS=new ArrayList<>();
        for (Food food : allFood) {
            foodTMS.add(new FoodTM(food.getFoodId(),food.getFoodName(),food.getPrice(),food.getPuentityOnHand()));
        }
        return foodTMS;
    }

    @Override
    public List<FoodTM> findPosibleFoods() throws Exception {
        List<Food> foods = foodDAO.handOnFoods();
        List<FoodTM> foodTMS=new ArrayList<>();
        for (Food food : foods) {
            foodTMS.add(new FoodTM(food.getFoodId(),food.getFoodName(),food.getPrice(),food.getPuentityOnHand()));
        }
        return foodTMS;
    }

    @Override
    public FoodTM findFood(String foodId) throws Exception {
        Food food = foodDAO.find(foodId);
        return new FoodTM(food.getFoodId(),food.getFoodName(),food.getPrice(),food.getPuentityOnHand());
    }

    @Override
    public boolean saveFood(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception {
        return foodDAO.save(new Food(foodId,foodName,price,quentityOnHand));
    }

    @Override
    public boolean updateFoods(String foodId, String foodName, BigDecimal price, int quentityOnHand) throws Exception {
        return foodDAO.update(new Food(foodId,foodName,price,quentityOnHand));
    }

    @Override
    public boolean deletFood(String key) throws Exception {
        return foodDAO.delete(key);
    }
}
