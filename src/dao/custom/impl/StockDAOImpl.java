package dao.custom.impl;

import dao.custom.StockDAO;
import entity.Stock;

import java.util.List;

public class StockDAOImpl implements StockDAO {
    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public Stock find(String key) {
        return null;
    }

    @Override
    public boolean save(Stock entity) {
        return false;
    }

    @Override
    public boolean update(Stock entity) {
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }
}
