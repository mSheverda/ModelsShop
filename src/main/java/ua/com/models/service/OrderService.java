package ua.com.models.service;

import ua.com.models.model.Order;

/**
 * Created by Max on 12/9/2016.
 */
public interface OrderService extends MainService<Order> {

    Order get(String number);

    void remove(String number);
}
