package ua.com.models.service;

import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryService extends MainService<Category> {
    /**
     * Возвращает категорию, у которой совпадает параметр url.
     */
    Category get(String url);

    /**
     * Удаляет категрию, у которого совпадает поле url.
     */
    void remove(String url);
}