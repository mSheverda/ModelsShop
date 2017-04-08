package ua.com.models.repository;

import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;

/**
 * Created by Max on 12/9/2016.
 */
public interface StatusRepository extends MainRepository<Status, Long> {

    Status findByTitle(StatusEnum title);

    void deleteByTitle(StatusEnum title);
}
