package ua.com.models.service;

import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryService extends MainService<Category> {

    Category get(String url);

    void remove(String url);
}