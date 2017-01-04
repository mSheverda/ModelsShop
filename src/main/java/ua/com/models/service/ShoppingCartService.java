package ua.com.models.service;

import ua.com.models.model.SalePosition;
import ua.com.models.model.ShoppingCart;

import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
public interface ShoppingCartService {

    /**
     * Возвращает объект корзину.
     */
    ShoppingCart getShoppingCart();

    /**
     * Добавляет торговую позицию в список корзины.
     */
    void add(SalePosition salePosition);

    /**
     * Возвращает список всех торговых позиций в корзине.
     */
    List getSalePositions();

    /**
     * Удаляет торговую позицию из корзины.
     */

    void remove(long id);  //(SalePosition salePosition);

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    void clear();

    /**
     * Возвращает цену корзины - цена всех продаж.
     */
    double getPrice();

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     */
    int getSize();
}
