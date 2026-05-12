package case_study.mvc.repository;

import case_study.mvc.entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String FILE_PATH = "src/case_study/mvc/data/customer.csv";

    public boolean add(Customer customer) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(convertToString(customer));
            bufferedWriter.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Không thể ghi file Customer");
            return false;
        }
    }

    private String convertToString(Customer customer) {
        return customer.getId() + "," + customer.getName() + "," + customer.getPhone();
    }

    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                Customer customer = new Customer(Integer.parseInt(data[0]), data[1], data[2]);
                list.add(customer);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file Customer");
        } catch (IOException e) {
            System.out.println("Không đọc được file Customer");
        }
        return list;
    }

    public boolean delete(int id) {
        List<Customer> list = findAll();
        boolean removed = list.removeIf(c -> c.getId() == id);

        if (removed) {
            writeAll(list);
        }
        
        return  removed;
    }

    public boolean update(Customer newCustomer) {
        List<Customer> list = findAll();

        for (Customer c : list) {
            if (c.getId() == newCustomer.getId()) {
                if (newCustomer.getName() != null) {
                    c.setName(newCustomer.getName());
                }

                if (newCustomer.getPhone() != null) {
                    c.setPhone(newCustomer.getPhone());
                }
                writeAll(list);
                return true;
            }
        }
        return false;
    }

    private void writeAll(List<Customer> list) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (Customer c : list) {
                bufferedWriter.write(convertToString(c));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi lại file Customer");
        }
    }

    public Customer findById(int id) {
        List<Customer> list = findAll();

        for (Customer c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Customer findByPhone(String phone) {
        List<Customer> list = findAll();

        for (Customer c : list) {
            if (c.getPhone().equals(phone)) {
                return c;
            }
        }
        return null;
    }
}
