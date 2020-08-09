package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory ==null)? (daoFactory=new DAOFactory()):daoFactory;
    }

    public <T extends SupperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case FOOD:
                return (T) new FoodDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            case STOCK:
                return (T) new StockDAOImpl();
            case ROOMBOOK:
                return (T) new RoomBookDateDAOImpl();
            case ORDERFOOD:
                return (T) new OrderFoodDAOImpl();
            case ORDERFOODITEM:
                return (T) new OrderFoodItemDAOImpl();
            case RELESECOOKITEM:
                return (T) new ReleseCookItemDAOImpl();
            default:
                return null;
        }
    }
}
