package ss12_java_collection_framework;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product p) {
        products.add(p);
    }

    public void edit(int id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public void display() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void search(String name) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Không tìm thấy tên sản phẩm này");
    }

    public void sortAsc() {
        products.sort(Comparator.comparing(Product::getPrice));
    }

    public void sortDesc() {
        products.sort(Comparator.comparing(Product::getPrice).reversed());
    }
}
