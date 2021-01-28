package vn.codegym.service;



import vn.codegym.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    Message findById(Long id);

    void save(Message customer);

    void remove(Long id);
}
