package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.OrderDAO;
import ua.com.models.model.Order;
import ua.com.models.service.OrderService;

/**
 * Created by Max on 12/9/2016.
 */
@Service
public class OrderServiceImpl extends MainServiceImpl<Order> implements OrderService {
    /**
     * Реализация интерфейса OrderDAO для работы заказов с базой данных.
     */
    private final OrderDAO dao;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     */
    @Autowired
    public OrderServiceImpl(OrderDAO dao) {
        super(dao);
        this.dao = dao;
    }

    /**
     * Возвращает заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра. Режим только для чтения.
     */
    @Override
    @Transactional(readOnly = true)
    public Order get(String number)
    {
        Order order = this.dao.get(number);
        return order;
    }

    /**
     * Удаляет заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    @Override
    @Transactional
    public void remove(String number)
    {
        this.dao.remove(number);
    }
}
