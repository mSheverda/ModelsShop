package ua.com.models.dao;

import ua.com.models.model.Photo;

/**
 * Created by Max on 12/4/2016.
 */
public interface PhotoDAO extends AbstractDao<Photo> {

    Photo get(String title);

    void remove(String title);
}