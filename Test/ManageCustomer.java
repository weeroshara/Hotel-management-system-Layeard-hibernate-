import dao.DAOFactory;
import dao.DAOType;
import dao.SupperDAO;
import dao.custom.CustomerDAO;
import entity.Customer;

public class ManageCustomer {
    public static void main(String[] args) {
        try {
            DAOFactory daoFactory = new DAOFactory();
            CustomerDAO customerDAO = daoFactory.getDAO(DAOType.CUSTOMER);
            customerDAO.save(new Customer("9752348175","kaml","077-9637531",3));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
