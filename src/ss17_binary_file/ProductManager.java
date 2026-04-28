package ss17_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_PATH = "src/ss17_binary_file/product.dat";

    public void writeToFile(List<Product> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public List<Product> readFromFile() {
        List<Product> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            list = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (Exception e) {
            System.out.println("Không đọc được file");
        }
        return list;
    }

    public void addProduct(Product p) {
        List<Product> list = readFromFile();
        list.add(p);
        writeToFile(list);
    }

    public void display() {
        List<Product> list = readFromFile();
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public void search(String keyword) {
        List<Product> list = readFromFile();
        for (Product p : list) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
            }
        }
    }
}
