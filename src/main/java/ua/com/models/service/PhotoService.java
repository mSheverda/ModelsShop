package ua.com.models.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */
public interface PhotoService extends MainService<Photo> {
    /**
     * Возвращает объект-изображение, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     * @param title Название объекта-изображения для возврата.
     * @return Объект класса {@link Photo} - объекта-изображение.
     */
    Photo get(String title);

    /**
     * Удаляет объект-изображение, у которого совпадает уникальное
     * название с значением входящего параметра.
     *
     * @param title Название объекта-изображения для удаления.
     */
    void remove(String title);

    /**
     * Сохраняет файл в файловой системе.
     *
     * @param photo Файл для сохранения.
     */
    void saveFile(MultipartFile photo);

    /**
     * Удаляет файл по url.
     *
     * @param url URL файла для удаления.
     */
    void deleteFile(String url);
}
