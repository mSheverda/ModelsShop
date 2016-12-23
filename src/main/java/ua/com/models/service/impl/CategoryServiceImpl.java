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
    /**
     * Реализация интерфейса для работы категорий с базой данных.
     */
    private final CategoryDAO dao;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     *
     */
    @Autowired
    public CategoryServiceImpl(CategoryDAO dao) {
        super(dao);
        this.dao = dao;
    }

    /**
     * Возвращает категорию из базы данных, у которой совпадает параметр url.
     * Режим только для чтения.
     */
    @Override
    @Transactional(readOnly = true)
    public Category get(String url)
    {
        Category category = this.dao.get(url);
        return category;
    }

    /**
     * Удаляет категрию из базы даных, у которого совпадает поле url.
     */
    @Override
    @Transactional
    public void remove(String url)
    {
        this.dao.remove(url);
    }
}