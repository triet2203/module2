package case_study.mvc.repository;

import case_study.mvc.entity.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String FILE_PATH = "src/case_study/mvc/data/product.csv";


    public boolean add(Product p) {
        if (findById(p.getId()) != null) {
            return false;
        }

        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(convertProductToString(p));
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Không thể ghi vào file Product");
            return false;
        }
    }

    public String convertProductToString(Product product) {
        return product.getId() + ","
                + product.getName() + ","
                + product.getPrice() + ","
                + product.getQuantity() + ","
                + product.getCategory() + ","
                + product.getCreatedDate();
    }

    public boolean update(Product newData) {
        List<Product> products = findAll();

        for (Product p : products) {
            if (p.getId() == newData.getId()) {
                if (newData.getName() != null) {
                    p.setName(newData.getName());
                }
                if (newData.getPrice() != null) {
                    p.setPrice(newData.getPrice());
                }
                if (newData.getQuantity() != null) {
                    p.setQuantity(newData.getQuantity());
                }
                if (newData.getCategory() != null) {
                    p.setCategory(newData.getCategory());
                }
                writeAll(products);
                return true;
            }
        }
        return false;
    }

    public Product findById(int id) {
        List<Product> products = findAll();

        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        List<Product> products = findAll();
        boolean removed = products.removeIf(p -> p.getId() == id);

        if (removed) {
            writeAll(products);
        }
        return removed;
    }

    private void writeAll(List<Product> products) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (Product p : products) {
                bufferedWriter.write(convertProductToString(p));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không ghi lại được file Product");
        }
    }

    public List<Product> findAll() {
        List<Product> product = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                product.add(new Product(Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        Integer.parseInt(data[3]),
                        data[4],
                        LocalDate.parse(data[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Không đọc được file");
        }
        return product;
    }


}
