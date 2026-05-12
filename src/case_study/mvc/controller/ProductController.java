package case_study.mvc.controller;

import case_study.mvc.entity.Product;
import case_study.mvc.service.impl.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService = ProductService.getInstance();

    public List<Product> findAll() {
        return productService.findAll();
    }

    public boolean add(Product p) {
        return productService.add(p);
    }

    public boolean update(Product p) {
        return productService.update(p);
    }

    public boolean delete(int id) {
        return productService.delete(id);
    }

    public Product findById(int id) {
        return productService.findById(id);
    }
}
