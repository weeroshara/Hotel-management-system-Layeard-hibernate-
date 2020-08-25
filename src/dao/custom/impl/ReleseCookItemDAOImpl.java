package dao.custom.impl;

import dao.custom.ReleseCookItemDAO;
import entity.ReleseCookItem;
import entity.ReleseCookItemPK;
import org.hibernate.Session;

import java.util.List;

public class ReleseCookItemDAOImpl implements ReleseCookItemDAO {


    private Session session;

    @Override
    public void setSesion(Session sesion) {
        this.session=sesion;
    }

    @Override
    public List<ReleseCookItem> findAll() {
        return null;
    }

    @Override
    public ReleseCookItem find(ReleseCookItemPK key) {
        return null;
    }

    @Override
    public void save(ReleseCookItem entity) {
    }

    @Override
    public void update(ReleseCookItem entity) {
    }

    @Override
    public void delete(ReleseCookItemPK key) {
    }
}
