package mvc_pratice.mvc.service;

import mvc_pratice.mvc.entity.Product;

import java.util.List;

public interface IService<T> {
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
    List<T> findAll();
}
