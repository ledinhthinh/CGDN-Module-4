package vn.codegym.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.User;
import vn.codegym.repository.UserRepository;
import vn.codegym.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }
}
