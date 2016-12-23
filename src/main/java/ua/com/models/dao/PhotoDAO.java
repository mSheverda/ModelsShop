package ua.com.models.dao;

import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */
public interface PhotoDAO extends AbstractDao<Photo> {
    /**
     * Возвращает объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     */
    Photo get(String title);

    /**
     * Удаляет объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     */
    void remove(String title);
}