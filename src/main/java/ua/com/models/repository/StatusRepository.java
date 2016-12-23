package ua.com.models.repository;

import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;

/**
 * Created by Max on 12/9/2016.
 */
public interface StatusRepository extends MainRepository<Status, Long> {
    /**
     * Возвращает статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    Status findByTitle(StatusEnum title);

    /**
     * Удаляет статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    void deleteByTitle(StatusEnum title);
}
