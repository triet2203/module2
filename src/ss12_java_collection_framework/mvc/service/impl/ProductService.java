package ss12_java_collection_framework.mvc.service.impl;

import ss12_java_collection_framework.mvc.entity.Product;
import ss12_java_collection_framework.mvc.repository.ProductRepository;
import ss12_java_collection_framework.mvc.service.IService;

import java.util.List;

public class ProductService implements IService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public boolean add(Product p) {
        return productRepository.add(p);
    }

    @Override
    public boolean edit(int id, String newName, double newPrice) {
        return productRepository.edit(id, newName, newPrice);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }

    @Override
    public List<Product> sortAsc() {
        return productRepository.sortAsc();
    }

    @Override
    public List<Product> sortDesc() {
        return productRepository.sortDesc();
    }

    @Override
    public List<Product> sortName() {
        return productRepository.sortName();
    }
}
