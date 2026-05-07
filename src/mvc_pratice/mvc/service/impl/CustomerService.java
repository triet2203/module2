package mvc_pratice.mvc.service.impl;

import mvc_pratice.mvc.entity.Customer;
import mvc_pratice.mvc.repository.CustomerRepository;
import mvc_pratice.mvc.service.IService;

import java.util.List;

public class CustomerService implements IService<Customer> {
    private CustomerRepository customerRepository = new CustomerRepository();

    private CustomerService() {
    }

    private static CustomerService instance;
    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }
}
