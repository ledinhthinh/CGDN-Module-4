package vn.codegym.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Role;
import vn.codegym.repository.RoleRepository;
import vn.codegym.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.remove(id);
    }
}
