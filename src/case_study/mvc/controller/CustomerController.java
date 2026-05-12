package case_study.mvc.controller;

import case_study.mvc.entity.Customer;
import case_study.mvc.service.impl.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService customerService = CustomerService.getInstance();

    public boolean add(Customer customer) {
        return customerService.add(customer);
    }

    public boolean update(Customer customer) {
        return customerService.update(customer);
    }

    public boolean delete(int id) {
        return customerService.delete(id);
    }

    public List<Customer> findAll() {
        return customerService.findAll();
    }

    public Customer findById(int id) {
        return customerService.findById(id);
    }

    public Customer findByPhone(String phone) {
        return customerService.findByPhone(phone);
    }
}
