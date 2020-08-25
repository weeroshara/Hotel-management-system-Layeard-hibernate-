package dao;

import entity.Customer;
import entity.SupperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T extends SupperEntity,ID extends Serializable> extends SupperDAO{
    List<T> findAll() throws Exception;
    T find(ID key) throws Exception;
    void save(T entity) throws Exception;
    void update(T entity) throws Exception;
    void delete(ID key) throws Exception;
}
