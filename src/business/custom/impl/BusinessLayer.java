package business.custom.impl;

import dao.DAOFactory;
import dao.DAOType;
import dao.SupperDAO;
import dao.custom.CustomerDAO;
import db.HibernateUtil;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.CustomerTM;

import java.util.ArrayList;
import java.util.List;

public class BusinessLayer {

    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    public List<CustomerTM> getAllCustomers(){

        Session session = HibernateUtil.getSesionFactory().openSession();
        Transaction tx=null;

        List<CustomerTM> customerTMS=new ArrayList<>();

        try {
            tx=session.beginTransaction();

            List<Customer> allCustomers = customerDAO.findAll();
            for (Customer allCustomer : allCustomers) {
                customerTMS.add(new CustomerTM(allCustomer.getNic(),allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
            }

            tx.commit();
        }catch (Throwable th) {
            th.printStackTrace();
            tx.rollback();
        }
        return customerTMS;

//        try {
//            CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
//            List<Customer> allCustomers = customerDAO.findAll();
//            List<CustomerTM> customerTMS=new ArrayList<>();
//
//            for (Customer allCustomer : allCustomers) {
//                customerTMS.add(new CustomerTM(allCustomer.getNic(),allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
//            }
//            return customerTMS;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }





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
