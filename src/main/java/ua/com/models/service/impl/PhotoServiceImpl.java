package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.models.dao.PhotoDAO;
import ua.com.models.model.Photo;
import ua.com.models.service.PhotoService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Max on 12/4/2016.
 */
@Service
public class PhotoServiceImpl extends MainServiceImpl<Photo> implements PhotoService {

    /**
     * Путь для сохранения файлов в файловой системе.
     */
    private static final String PATH = "c:/Server/apache-tomcat-8.0.33/webapps/ROOT/resources/img/"; //!

    /**
     * Реализация интерфейса для работы изображений с базой данных.
     */
    private final PhotoDAO dao;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     *
     */
    @Autowired
    public PhotoServiceImpl(PhotoDAO dao) {
        super(dao);
        this.dao = dao;
    }

    /**
     * Возвращает объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра. Режим только для чтения.
    */
    @Override
    @Transactional(readOnly = true)
    public Photo get(String title)
    {

        Photo photo = this.dao.get(title);
        return photo;
    }

    /**
     * Удаляет объект-изображение из базы даных, у которого совпадает уникальное
     * название с значением входящего параметра.
     */
    @Override
    @Transactional
    public void remove(String title)
    {
        dao.remove(title);
    }

    /**
     * Сохраняет файл в файловой системе.
     */
    @Override
    @Transactional
    public void saveFile(MultipartFile photo) {
        if (photo != null && !photo.isEmpty()) {
            try (OutputStream stream = new FileOutputStream(PATH + photo.getOriginalFilename())) {
                stream.write(photo.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Удаляет файл по url.
     */
    @Override
    @Transactional
    public void deleteFile(String url) {
        if (url != null && !url.isEmpty()) {
            File file = new File(PATH + url);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }
}
