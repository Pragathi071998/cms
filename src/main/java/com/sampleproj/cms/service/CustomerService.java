package com.sampleproj.cms.service;
import com.sampleproj.cms.dao.Customerdao;
import com.sampleproj.cms.exception.CustomerNotFoundException;
import com.sampleproj.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    @Autowired
    private Customerdao customerdao;

    public Customer addCustomer(Customer customer){
        return customerdao.save(customer);
    }
    public List<Customer> getCustomers() {
        return customerdao.findAll();
    }
    public Customer getCustomer(int customerId){
        Optional<Customer> optionalCustomer = customerdao.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not Available");
        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId((customerId));
        return customerdao.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerdao.deleteById(customerId);
    }
}
