package business.custom.impl;

import business.BOFactory;
import business.BOType;
import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.fxml.FXMLLoader;
import util.CustomerTM;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
    @Override
    public List<CustomerTM> getAllCustomers() {
            try {
                List<Customer> allCustomers = customerDAO.findAll();
                List<CustomerTM> customerTMS = new ArrayList<>();

                for (Customer allCustomer : allCustomers) {
                    customerTMS.add(new CustomerTM(allCustomer.getNic(), allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
                }
                return customerTMS;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    @Override
    public CustomerTM getCustomer(String id) throws Exception {
        Customer customer = customerDAO.find(id);
        return new CustomerTM(customer.getNic(),customer.getName(),customer.getPhomeNumber(),customer.getNoOfMembors());
    }


    @Override
    public boolean saveCustomer(String id, String name, String phoneNo, int membors) throws Exception {
        return customerDAO.save(new Customer(id,name,phoneNo,membors));
    }

    @Override
    public boolean updateCustmer(String name, String phoneNo, int membors, String id) throws Exception {
        return customerDAO.update(new Customer(id,name,phoneNo,membors));
    }

    @Override
    public boolean deletCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }


}
