package ss12_java_collection_framework.mvc.controller;

import ss12_java_collection_framework.mvc.entity.Product;
import ss12_java_collection_framework.mvc.service.IService;
import ss12_java_collection_framework.mvc.service.impl.ProductService;

import java.util.List;

public class ProductController {
    private IService productService = new ProductService();

    public List<Product> findAll() {
        return productService.findAll();
    }

    public boolean add(Product p) {
        return productService.add(p);
    }

    public boolean edit(int id, String name, double price) {
        return productService.edit(id, name, price);
    }

    public boolean delete(int id) {
        return productService.delete(id);
    }

    public List<Product> search(String name) {
        return productService.search(name);
    }

    public List<Product> sortAsc() {
        return productService.sortAsc();
    }

    public List<Product> sortDesc() {
        return productService.sortDesc();
    }
}
