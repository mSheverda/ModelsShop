package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.OrderDAO;
import ua.com.models.model.Order;
import ua.com.models.repository.OrderRepository;

/**
 * Created by Max on 12/9/2016.
 */
@Repository
public class OrderDAOImpl extends AbstractDaoImpl<Order> implements OrderDAO {
    /**
     * Реализация репозитория OrderRepository для работы категорий с базой данных.
     */
    private final OrderRepository repository;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     */
    @Autowired
    public OrderDAOImpl(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Возвращает заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    @Override
    public Order get(String number) {
        return this.repository.findByNumber(number);
    }

    /**
     * Удаляет заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    @Override
    public void remove(String number) {
        this.repository.deleteByNumber(number);
    }
}