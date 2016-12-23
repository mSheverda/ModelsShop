package ua.com.models.repository;

import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */

public interface PhotoRepository extends MainRepository<Photo, Long> {
    /**
     * Возвращает объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     * @param title Название объекта-изображения для возврата.
     * @return Объект класса {@link Photo} - объект-изображение.
     */
    Photo findByTitle(String title);

    /**
     * Удаляет объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     * @param title Название объекта-изображения для удаление.
     */
    void deleteByTitle(String title);
}

