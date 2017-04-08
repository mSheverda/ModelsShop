package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.CategoryDAO;
import ua.com.models.model.Category;
import ua.com.models.service.CategoryService;

/**
 * Created by Max on 12/4/2016.
 */

@Service
public class CategoryServiceImpl extends MainServiceImpl<Category> implements CategoryService {

    private final CategoryDAO dao;

    @Autowired
    public CategoryServiceImpl(CategoryDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Category get(String url)
    {
        Category category = this.dao.get(url);
        return category;
    }

    @Override
    @Transactional
    public void remove(String url)
    {
        this.dao.remove(url);
    }
}