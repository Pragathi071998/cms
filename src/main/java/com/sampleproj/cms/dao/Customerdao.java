package com.sampleproj.cms.dao;

import com.sampleproj.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Customerdao extends CrudRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
}
