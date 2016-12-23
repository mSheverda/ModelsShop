package ua.com.models.dao;

import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;

/**
 * Created by Max on 12/9/2016.
 */
public interface StatusDAO extends AbstractDao<Status> {
    /**
     * Добавляет статус в базу даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    void add(StatusEnum title, String description);

    /**
     * Возвращает статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    Status get(StatusEnum title);

    /**
     * Возвращает из базы даных статус по-умолчанию.
     */
    Status getDefault();

    /**
     * Удаляет статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    void remove(StatusEnum title);
}