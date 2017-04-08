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

    private final ShoppingCartDAO shoppingCartDAO;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public ShoppingCart getShoppingCart()
    {
        ShoppingCart shoppingCart = this.shoppingCartDAO.get();
        return shoppingCart;
    }

    @Override
    @Transactional
    public void add(SalePosition salePosition) {
        if (salePosition != null) {
            this.shoppingCartDAO.addSalePosition(salePosition);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalePosition> getSalePositions() {
        return this.shoppingCartDAO.getSalePositions();
    }

    @Override
    @Transactional
    public SalePosition get(long id){
       return this.shoppingCartDAO.getSalePosition(id);
    }

    @Override
    @Transactional
    public void remove(long id){
        this.shoppingCartDAO.removeSalePosition(id);
    }

    @Override
    @Transactional
    public void clear() {
        this.shoppingCartDAO.clearSalePositions();
    }

    @Override
    @Transactional(readOnly = true)
    public double getPrice() {
        return this.shoppingCartDAO.getPrice();
    }

    @Override
    @Transactional(readOnly = true)
    public int getSize() {
        return this.shoppingCartDAO.getSize();
    }
}