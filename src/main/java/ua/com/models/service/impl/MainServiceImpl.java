package ua.com.models.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.AbstractDao;
import ua.com.models.model.Model;
import ua.com.models.service.MainService;

import java.util.List;

public abstract class MainServiceImpl<T extends Model> implements MainService<T> {

    private final AbstractDao<T> dao;

    public MainServiceImpl(AbstractDao<T> dao) {
        super();
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(T model) {
        if (model != null) {
            this.dao.add(model);
        }
    }

    @Override
    @Transactional
    public void add(List<T> models) {
        if (models != null && !models.isEmpty()) {
            this.dao.add(models);
        }
    }

    @Override
    @Transactional
    public void update(T model) {
        if (model != null) {
            this.dao.update(model);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T get(Long id)
    {
        T model = this.dao.get(id);

        return this.dao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return this.dao.getAll();
    }

    @Override
    @Transactional
    public void remove(T model) {
        if (model != null) {
            this.dao.remove(model);
        }
    }

    @Override
    @Transactional
    public void remove(Long id)
    {
        this.dao.remove(id);
    }

    @Override
    @Transactional
    public void remove(List<T> models) {
        if (models != null && !models.isEmpty()) {
            this.dao.remove(models);
        }
    }

    @Override
    @Transactional
    public void removeAll() {
        this.dao.removeAll();
    }
}
