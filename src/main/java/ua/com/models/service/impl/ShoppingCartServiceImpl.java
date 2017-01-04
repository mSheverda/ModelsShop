package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.ShoppingCartDAO;
import ua.com.models.model.SalePosition;
import ua.com.models.model.ShoppingCart;
import ua.com.models.service.ShoppingCartService;

import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    /**
     * Реализация интерфейса для работы з торговой корзиной.
     */
    private final ShoppingCartDAO shoppingCartDAO;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring автоматически инициализировать объект.
     */
    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

    /**
     * Возвращает объект корзину. Режим только для чтения.
     */
    @Override
    @Transactional(readOnly = true)
    public ShoppingCart getShoppingCart()
    {
        ShoppingCart shoppingCart = this.shoppingCartDAO.get();
        return shoppingCart;
    }

    /**
     * Добавляет торговую позицию в список корзины.
     */
    @Override
    @Transactional
    public void add(SalePosition salePosition) {
        if (salePosition != null) {
            this.shoppingCartDAO.addSalePosition(salePosition);
        }
    }

    /**
     * Возвращает список всех торговых позиций в корзине. Режим только для чтения.
     *
     * @return Объект типа {@link List} - список торговых позиций.
     */
    @Override
    @Transactional(readOnly = true)
    public List<SalePosition> getSalePositions() {
        return this.shoppingCartDAO.getSalePositions();
    }

    /**
     * Удаляет торговую позицию из корзины.
     */
    @Override
    @Transactional
    public void remove(long id){ //(SalePosition salePosition) {
        //if (id != null)
       // {
            this.shoppingCartDAO.removeSalePosition(id);
       // }
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    @Override
    @Transactional
    public void clear() {
        this.shoppingCartDAO.clearSalePositions();
    }

    /**
     * Возвращает цену корзины - цена всех продаж. Режим только для чтения.
     */
    @Override
    @Transactional(readOnly = true)
    public double getPrice() {
        return this.shoppingCartDAO.getPrice();
    }

    /**
     * Возвращает размер корзины, то есть количество товаров в корзине.
     * Режим только для чтения.
     */
    @Override
    @Transactional(readOnly = true)
    public int getSize() {
        return this.shoppingCartDAO.getSize();
    }
}