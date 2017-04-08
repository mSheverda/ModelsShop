package ua.com.models.repository;

import ua.com.models.model.Category;

/**
 * Created by Max on 12/4/2016.
 */
public interface CategoryRepository extends MainRepository<Category, Long> {

    Category findByUrl(String url);

    void deleteByUrl(String url);
}
