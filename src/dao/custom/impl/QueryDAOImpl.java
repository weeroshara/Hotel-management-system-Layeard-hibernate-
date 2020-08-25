package dao.custom.impl;

import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CustomerDAO;
import dao.custom.QueryDAO;
import entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }


}
