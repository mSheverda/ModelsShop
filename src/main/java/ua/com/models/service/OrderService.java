package ua.com.models.service;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderService extends MainService<Order> {
    /**
     * Возвращает заказ, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    Order get(String number);

    /**
     * Удаляет заказ, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    void remove(String number);
}
