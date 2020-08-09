package dao;

import entity.Customer;
import entity.SupperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T extends SupperEntity,ID extends Serializable> extends SupperDAO{
    List<T> findAll() throws Exception;
    T find(ID key) throws Exception;
    boolean save(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(ID key) throws Exception;
}
