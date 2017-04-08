package ua.com.models.dao;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderDAO extends AbstractDao<Order> {

    Order get(String number);

    void remove(String number);
}