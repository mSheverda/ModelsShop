package ua.com.models.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */
public interface PhotoService extends MainService<Photo> {

    Photo get(String title);

    void remove(String title);

    void saveFile(MultipartFile photo);

    void deleteFile(String url);
}
