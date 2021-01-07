package com.thinh.service;

import com.thinh.model.Dictionary;
import com.thinh.repository.DictionaryRepository;
import com.thinh.repository.DictionaryRepositoryImpl;

import java.util.List;

public class DictionaryServiceImpl implements DictionaryService{
    DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
    @Override
    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }
}
