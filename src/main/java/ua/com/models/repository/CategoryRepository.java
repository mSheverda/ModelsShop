package ua.com.models.repository;

import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryRepository extends MainRepository<Category, Long> {
    /**
     * Возвращает категорию из базы данных, у которой совпадает параметр url.
     *
     */
    Category findByUrl(String url);

    /**
     * Удаляет категрию из базы даных, у которого совпадает поле url.

     */
    void deleteByUrl(String url);
}
