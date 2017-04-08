package ua.com.models.dao;

import ua.com.models.dao.AbstractDao;
import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryDAO extends AbstractDao<Category> {

    Category get(String url);

    void remove(String url);
}

