package business.custom.impl;

import dao.DAOFactory;
import dao.DAOType;
import dao.SupperDAO;
import dao.custom.CustomerDAO;
import entity.Customer;
import util.CustomerTM;

import java.util.ArrayList;
import java.util.List;

public class BusinessLayer {

    public List<CustomerTM> getAllCustomers(){
        try {
            CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
            List<Customer> allCustomers = customerDAO.findAll();
            List<CustomerTM> customerTMS=new ArrayList<>();

            for (Customer allCustomer : allCustomers) {
                customerTMS.add(new CustomerTM(allCustomer.getNic(),allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
            }
            return customerTMS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        /*
        CustomerDAO customerDao =DAOFactory.getInstance().getDao(DAOType.CUSTOMER);

        List<Customer> allCustomersList =customerDao.findAll();
        List<CustomerTM> customerTMS=new ArrayList<>();
        for (Object allCustomers : allCustomersList) {

            Customer allCustomer=(Customer)allCustomers;
            customerTMS.add(new CustomerTM(allCustomer.getId(),allCustomer.getName(),allCustomer.getAddress()));
        }
        return customerTMS;
         */
    }

    //public Cus
}
