package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.ShoppingCartDAO;
import ua.com.models.model.SalePosition;
import ua.com.models.model.ShoppingCart;

import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    /**
     * Объект корзина, в которой хранятся торговые позиции клиента.
     */
    private final ShoppingCart shoppingCart;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     */
    @Autowired
    public ShoppingCartDAOImpl(ShoppingCart shoppingCart) {
        super();
        this.shoppingCart = shoppingCart;
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     */
    @Override
    public List<SalePosition> getSalePositions() {
        return this.shoppingCart.getSalePositions();
    }

    /**
     * Добавляет торговую позицию в список корзины.
     */
    @Override
    public void addSalePosition(SalePosition salePosition) {
        this.shoppingCart.addSalePosition(salePosition);
    }

    /**
     * Удаляет торговую позицию из корзины.
     */
    @Override
    public void removeSalePosition(long id //SalePosition salePosition
    )
    {
        this.shoppingCart.removeSalePosition(id);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    @Override
    public void clearSalePositions() {
        this.shoppingCart.clearSalePositions();
    }

    /**
     * Возвращает объект-корзину целиком.
     */
    @Override
    public ShoppingCart get() {
        return this.shoppingCart;
    }

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     */
    @Override
    public int getSize() {
        return this.shoppingCart.getSize();
    }

    /**
     * Возвращает цену корзины - цена всех продаж.
     */
    @Override
    public double getPrice() {
        return this.shoppingCart.getPrice();
    }
}
