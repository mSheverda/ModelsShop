package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.StatusDAO;
import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;
import ua.com.models.repository.StatusRepository;

/**
 * Created by Max on 12/9/2016.
 */
@Repository
public class StatusDAOImpl extends AbstractDaoImpl<Status> implements StatusDAO {
    /**
     * Реализация репозитория StatusRepository для работы статусов заказов с базой данных.
     */
    private final StatusRepository repository;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     */
    @Autowired
    public StatusDAOImpl(StatusRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Добавляет статус в базу даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    @Override
    public void add(StatusEnum title, String description) {
        this.repository.save(new Status(title, description));
    }

    /**
     * Возвращает статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    @Override
    public Status get(StatusEnum title) {
        return this.repository.findByTitle(title);
    }

    /**
     * Возвращает из базы даных статус по-умолчанию.
     */
    @Override
    public Status getDefault() {
        return this.repository.findOne((long) 1);
    }

    /**
     * Удаляет статус из базы даных по названию, которое может принимать
     * одно из значений перечисления StatusEnum.
     */
    @Override
    public void remove(StatusEnum title) {
        this.repository.deleteByTitle(title);
    }
}
