package ua.com.models.dao;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderDAO extends AbstractDao<Order> {
    /**
     * Возвращает заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    Order get(String number);

    /**
     * Удаляет заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    void remove(String number);
}