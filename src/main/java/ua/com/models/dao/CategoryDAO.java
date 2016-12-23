package ua.com.models.dao;

import ua.com.models.dao.AbstractDao;
import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryDAO extends AbstractDao<Category> {
    /**
     * Возвращает категорию из базы данных, у которой совпадает параметр url.

     */
    Category get(String url);

    /**
     * Удаляет категрию из базы даных, у которого совпадает поле url.

     */
    void remove(String url);
}

