package ua.com.models.dao;

import ua.com.models.model.SalePosition;
import ua.com.models.model.ShoppingCart;

import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
public interface ShoppingCartDAO {
    /**
     * Возвращает список всех торговых позиций в корзине.
     */
    List<SalePosition> getSalePositions();

    /**
     * Добавляет торговую позицию в список корзины.
     */
    void addSalePosition(SalePosition salePosition);

    /**
     * Удаляет торговую позицию из корзины.
     */
    void removeSalePosition(SalePosition salePosition);

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    void clearSalePositions();

    /**
     * Возвращает объект-корзину целиком.
     */
    ShoppingCart get();

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     */
    int getSize();

    /**
     * Возвращает цену корзины - цена всех торговых позиций.
     */
    double getPrice();
}
