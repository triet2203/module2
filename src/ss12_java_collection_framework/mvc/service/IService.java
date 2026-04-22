package ss12_java_collection_framework.mvc.service;

import ss12_java_collection_framework.mvc.entity.Product;

import java.util.List;

public interface IService {
    boolean add(Product p);
    boolean edit(int id, String newName, double newPrice);
    boolean delete(int id);
    List<Product> findAll();
    List<Product> search(String name);
    List<Product> sortAsc();
    List<Product> sortDesc();
    List<Product> sortName();
}
