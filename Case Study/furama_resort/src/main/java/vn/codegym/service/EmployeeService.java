package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void update(Employee employee);

    void delete(String id);

    Employee findById(String id);

    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable,String nameSearch);
}
