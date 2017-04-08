package ua.com.models.service;

import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;

/**
 * Created by Max on 12/9/2016.
 */
public interface StatusService extends MainService<Status> {

    void add(StatusEnum title, String description);

    Status get(StatusEnum title);

    Status getDefault();

    void remove(StatusEnum title);

}