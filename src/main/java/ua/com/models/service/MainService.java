package ua.com.models.service;


import ua.com.models.model.Model;

import java.util.List;

public interface MainService<T extends Model> {

    void add(T model);

    void add(List<T> models);

    void update(T model);

    T get(Long id);

    List<T> getAll();

    void remove(T model);

    void remove(Long id);

    void remove(List<T> models);

    void removeAll();
}