package ua.com.models.service;

import ua.com.models.model.SalePosition;
import ua.com.models.model.ShoppingCart;

import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
public interface ShoppingCartService {

    ShoppingCart getShoppingCart();

    void add(SalePosition salePosition);

    List getSalePositions();

    void remove(long id);

    SalePosition get(long id);

    void clear();

    double getPrice();

    int getSize();
}
