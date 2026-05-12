package case_study.mvc.service.impl;

import case_study.mvc.entity.Product;
import case_study.mvc.repository.ProductRepository;
import case_study.mvc.service.IProductService;

import java.util.List;

public class ProductService implements IProductService{
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
