package dao.custom.impl;

import dao.custom.StockDAO;
import entity.Stock;
import org.hibernate.Session;

import java.util.List;

public class StockDAOImpl implements StockDAO {
    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public Stock find(String key) {
        return null;
    }

    @Override
    public void save(Stock entity) {

    }

    @Override
    public void update(Stock entity) {

    }

    @Override
    public void delete(String key) {

    }
}
