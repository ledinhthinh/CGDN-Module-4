package com.thinh.repository;

import com.thinh.model.Dictionary;

import java.util.List;

public interface DictionaryRepository {
    List<Dictionary> findAll();
}
