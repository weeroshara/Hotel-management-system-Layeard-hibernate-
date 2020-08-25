package business.custom.impl;

import business.BOFactory;
import business.BOType;
import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import db.HibernateUtil;
import entity.Customer;
import javafx.fxml.FXMLLoader;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.CustomerTM;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
    @Override
    public List<CustomerTM> getAllCustomers() {

        Session session = HibernateUtil.getSesionFactory().openSession();
        customerDAO.setSesion(session);
        Transaction tx=null;

        List<CustomerTM> customerTMS = new ArrayList<>();
        try {
            tx=session.beginTransaction();

            List<Customer> allCustomers = customerDAO.findAll();

            for (Customer allCustomer : allCustomers) {
                customerTMS.add(new CustomerTM(allCustomer.getNic(), allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
            }

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }
        return customerTMS;


        /* try {
                List<Customer> allCustomers = customerDAO.findAll();
                List<CustomerTM> customerTMS = new ArrayList<>();

                for (Customer allCustomer : allCustomers) {
                    customerTMS.add(new CustomerTM(allCustomer.getNic(), allCustomer.getName(), allCustomer.getPhomeNumber(), allCustomer.getNoOfMembors()));
                }
                return customerTMS;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }*/

    }

    @Override
    public CustomerTM getCustomer(String id) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        customerDAO.setSesion(session);
        Transaction tx=null;

        CustomerTM customerTM=null;
        try {
            tx=session.beginTransaction();

            Customer customer = customerDAO.find(id);
            customerTM = new CustomerTM(customer.getNic(), customer.getName(), customer.getPhomeNumber(), customer.getNoOfMembors());

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }
        return customerTM;

    }


    @Override
    public void saveCustomer(String id, String name, String phoneNo, int membors) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        customerDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            customerDAO.save(new Customer(id,name,phoneNo,membors));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public void updateCustmer(String name, String phoneNo, int membors, String id) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        customerDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            customerDAO.update(new Customer(id,name,phoneNo,membors));

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }

    @Override
    public void deletCustomer(String id) throws Exception {
        Session session = HibernateUtil.getSesionFactory().openSession();
        customerDAO.setSesion(session);
        Transaction tx=null;

        try {
            tx=session.beginTransaction();

            customerDAO.delete(id);

            tx.commit();
        }catch (Throwable th){
            th.printStackTrace();
            tx.rollback();
        }

    }


}
