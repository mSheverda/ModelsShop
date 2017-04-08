package ua.com.models.repository;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderRepository extends MainRepository<Order, Long> {

    Order findByNumber(String number);

    void deleteByNumber(String number);
}