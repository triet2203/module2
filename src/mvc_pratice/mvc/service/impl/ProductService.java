package mvc_pratice.mvc.service.impl;

import mvc_pratice.mvc.entity.Product;
import mvc_pratice.mvc.repository.ProductRepository;
import mvc_pratice.mvc.service.IService;

import java.util.List;

public class ProductService implements IService<Product> {
    private ProductRepository productRepository = new ProductRepository();

    private ProductService() {
    }

    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public boolean add(Product p) {
        return productRepository.add(p);
    }

    @Override
    public boolean update(Product p) {
        return productRepository.update(p);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
