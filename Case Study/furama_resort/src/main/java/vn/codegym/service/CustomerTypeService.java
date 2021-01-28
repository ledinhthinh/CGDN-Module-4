package vn.codegym.service;

import vn.codegym.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {

    List<CustomerType> findAll();

    void save(CustomerType customerType);

    void update(CustomerType customerType);

    void delete(Integer id);

    CustomerType findById(Integer id);

}
