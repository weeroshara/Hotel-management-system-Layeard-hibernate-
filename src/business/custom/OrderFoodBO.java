package business.custom;

import business.SuperBO;
import util.OrderFoodTM;

import java.util.List;

public interface OrderFoodBO extends SuperBO {
    public String orderId() throws Exception;
    public boolean placeOrderFood(String orderId, String customerId, List<OrderFoodTM> orderFoodTMS) throws Exception;
}
