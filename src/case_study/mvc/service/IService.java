package case_study.mvc.service;

import java.util.List;

public interface IService<T> {
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
    List<T> findAll();
}
