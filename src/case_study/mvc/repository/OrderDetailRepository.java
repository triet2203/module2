package case_study.mvc.repository;

import case_study.mvc.entity.OrderDetail;
import case_study.mvc.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepository {
    private static final String FILE_PATH = "src/case_study/mvc/data/order_detail.csv";

    public boolean add(OrderDetail orderDetail) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(convertToString(orderDetail));
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file order_detail");
            return false;
        }
    }

    private String convertToString(OrderDetail orderDetail) {
        return orderDetail.getOrderId() + ","
                + orderDetail.getProduct().getId() + ","
                + orderDetail.getProduct().getName() + ","
                + orderDetail.getQuantity() + ","
                + orderDetail.getPrice();
    }

    public List<OrderDetail> findAll() {
        List<OrderDetail> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;

            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");

                if (data.length >= 5) {
                    String orderId = data[0];

                    Product product = new Product();
                    product.setId(Integer.parseInt(data[1]));
                    product.setName(data[2]);

                    int quantity = Integer.parseInt(data[3]);
                    double price = Double.parseDouble(data[4]);

                    OrderDetail orderDetail = new OrderDetail(orderId, product, quantity, price);
                    list.add(orderDetail);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm được file order_detail");
        } catch (IOException e) {
            System.out.println("Lỗi không đọc được file order_detail");
        }
        return list;
    }

    public List<OrderDetail> findByOrderId(String orderId) {
        List<OrderDetail> result = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                data = line.split(",");

                if (data.length >= 5 && data[0].equals(orderId)) {
                    Product product = new Product();
                    product.setId(Integer.parseInt(data[1]));
                    product.setName(data[2]);

                    int quantity = Integer.parseInt(data[3]);
                    double price = Double.parseDouble(data[4]);

                    OrderDetail orderDetail = new OrderDetail(orderId, product, quantity, price);
                    result.add(orderDetail);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file order_detail");
        } catch (IOException e) {
            System.out.println("Không đọc được file order_detail");
        }
        return result;
    }
}
