package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<Customer> findAll() throws Exception{

        return session.createQuery("FROM entity.Customer").list();

//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer");
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()){
//            customers.add(new Customer(resultSet.getString(1),resultSet.getString(2),
//                    resultSet.getString(3),resultSet.getInt(4)));
//        }
//        return customers;
    }

    @Override
    public Customer find(String key) throws Exception{
        return session.get(Customer.class,key);
//        try {
//            ResultSet resultSet = CrudUtil.execute("SELECT *FROM Customer WHERE nic=?", key);
//            if (resultSet.next()){
//                return new Customer(resultSet.getString(1),resultSet.getString(2),
//                        resultSet.getString(3),resultSet.getInt(4));
//            }
//            return null;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
    }

    @Override
    public void save(Customer customer) throws Exception{
        session.save(customer);
       /* CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)",entity.getNic(),entity.getName(),
                entity.getPhomeNumber(),entity.getNoOfMembors());*/
    }

    @Override
    public void update(Customer customer) throws Exception{
        session.update(customer);
        /*CrudUtil.execute("UPDATE Customer SET name=?, phomeNumber=?, noOfMembore=? WHERE nic=?",entity.getName(),
                entity.getPhomeNumber(),entity.getNoOfMembors(),entity.getNic());*/
    }

    @Override
    public void delete(String key) throws Exception{
        session.delete(session.get(Customer.class,key));
        /*CrudUtil.execute("DELETE FROM Customer WHERE nic=?",key);*/
    }

}
