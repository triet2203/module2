package case_study.mvc.service;

import case_study.mvc.entity.Customer;

public interface ICustomerService extends IService<Customer>{
    Customer findById(int id);

    Customer findByPhone(String phone);
}
