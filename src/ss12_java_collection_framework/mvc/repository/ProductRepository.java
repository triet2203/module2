package ss12_java_collection_framework.mvc.repository;

import ss12_java_collection_framework.mvc.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Apple", 3000));
        products.add(new Product(2, "Samsung", 1000));
        products.add(new Product(3, "Xiaomi", 9000));
        products.add(new Product(4, "Oppo", 500));
        products.add(new Product(5, "Nokia", 700));
        products.add(new Product(6, "Vivo", 2000));
        products.add(new Product(7, "Realme", 4000));
        products.add(new Product(8, "Huawei", 6000));
        products.add(new Product(9, "Lenovo", 8000));
        products.add(new Product(10, "Asus", 5000));
    }

    public boolean add(Product p) {
        return products.add(p);
    }

    public boolean edit(int id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public List<Product> search(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> sortAsc() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparing(Product::getPrice));
        return sortedList;
    }

    public List<Product> sortDesc() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparing(Product::getPrice).reversed());
        return sortedList;
    }
}
