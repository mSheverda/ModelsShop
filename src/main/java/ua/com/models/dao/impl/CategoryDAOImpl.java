package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.CategoryDAO;
import ua.com.models.model.Category;
import ua.com.models.repository.CategoryRepository;

/**
 * Created by Max on 12/4/2016.
 */
@Repository
public class CategoryDAOImpl extends AbstractDaoImpl<Category> implements CategoryDAO {
    /**
     * Реализация репозитория для работы категорий с базой данных.
     */
    private final CategoryRepository repository;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.

     */
    @Autowired
    public CategoryDAOImpl(CategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Возвращает категорию из базы данных, у которой совпадает параметр url.

     */
    @Override
    public Category get(String url) {
        return this.repository.findByUrl(url);
    }

    /**
     * Удаляет категрию из базы даных, у которого совпадает поле url.

     */
    @Override
    public void remove(String url) {
        this.repository.deleteByUrl(url);
    }
}