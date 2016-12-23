package ua.com.models.repository;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderRepository extends MainRepository<Order, Long> {
    /**
     * Возвращает заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    Order findByNumber(String number);

    /**
     * Удаляет заказ из базы даных, у которого совпадает уникальный номером
     * с значением входящего параметра.
     */
    void deleteByNumber(String number);
}