package ua.com.models.repository;

import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */

public interface PhotoRepository extends MainRepository<Photo, Long> {

    Photo findByTitle(String title);

    void deleteByTitle(String title);
}

