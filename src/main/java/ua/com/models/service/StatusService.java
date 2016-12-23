package ua.com.models.service;

import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;

/**
 * Created by Max on 12/9/2016.
 */
public interface StatusService extends MainService<Status> {
    /**
     * Добавляет статус по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    void add(StatusEnum title, String description);

    /**
     * Возвращает статус по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    Status get(StatusEnum title);

    /**
     * Возвращает статус по-умолчанию.
     */
    Status getDefault();

    /**
     * Удаляет статус по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    void remove(StatusEnum title);

}