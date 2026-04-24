package ss12_java_collection_framework.mvc.repository;

import ss12_java_collection_framework.mvc.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static ArrayList<Product> products = new ArrayList<>();

    public boolean add(Product p) {
        try (FileWriter fileWriter = new FileWriter("src/ss12_java_collection_framework/mvc/data/input.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(convertProduceToString(p));
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Không thể ghi vào file");
            return false;
        }
    }

    private String convertProduceToString(Product product) {
        return product.getId() + "," + product.getName() + "," + product.getPrice();
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
        List<Product> product = new ArrayList<>();

        try (FileReader fileReader = new FileReader("src/ss12_java_collection_framework/mvc/data/input.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                product.add(new Product(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Không đọc được file");
        }
        return product;
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

    public List<Product> sortName() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparing((Product p) -> p.getName().toLowerCase()).thenComparing(Product::getId));
        return sortedList;
    }
}
