package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.PhotoDAO;
import ua.com.models.model.Photo;
import ua.com.models.repository.PhotoRepository;

/**
 * Created by Max on 12/4/2016.
 */

@Repository
public class PhotoDAOImpl extends AbstractDaoImpl<Photo> implements PhotoDAO {
    /**
     * Реализация репозитория для работы изображений с базой данных.
     */
    private final PhotoRepository repository;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     *
     */
    @Autowired
    public PhotoDAOImpl(PhotoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Возвращает объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.

     */
    @Override
    public Photo get(String title) {
        return this.repository.findByTitle(title);
    }

    /**
     * Удаляет объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     */
    @Override
    public void remove(String title) {
        this.repository.deleteByTitle(title);
    }
}