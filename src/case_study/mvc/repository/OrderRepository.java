package case_study.mvc.repository;

import case_study.mvc.entity.Order;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final String FILE_PATH = "src/case_study/mvc/data/order.csv";

    public boolean add(Order order) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true );
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(convertToString(order));
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Không ghi được Order");
            return false;
        }
    }

    public String convertToString(Order order) {
        return order.getId() + "," + order.getCustomerId() + "," + order.getDate() + "," + order.getStatus();
    }

    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                Order order = new Order(Integer.parseInt(data[0]), Integer.parseInt(data[1]), LocalDate.parse(data[2]), data[3]);
                list.add(order);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Không đọc được file");
        }
        return list;
    }

    public Order findById(int id) {
        List<Order> list = findAll();
        for (Order o : list) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        List<Order> list = findAll();
        boolean removed = list.removeIf(o -> o.getId() == id);

        if (removed) {
            writeAll(list);
        }
        return removed;
    }

    private void writeAll(List<Order> list) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (Order o : list) {
                bufferedWriter.write(convertToString(o));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi lại file Order");
        }
    }

    public boolean update(Order newOrder) {
        List<Order> list = findAll();

        for (Order o : list) {
            if (o.getId() == newOrder.getId()) {
                if (newOrder.getCustomerId() != 0) {
                    o.setCustomerId(newOrder.getCustomerId());
                }

                if (newOrder.getDate() != null) {
                    o.setDate(newOrder.getDate());
                }

                if (newOrder.getStatus() != null) {
                    o.setStatus(newOrder.getStatus());
                }
                writeAll(list);
                return true;
            }
        }
        return false;
    }
}
