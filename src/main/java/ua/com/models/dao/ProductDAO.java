package ua.com.models.dao;


import ua.com.models.model.Product;

public interface ProductDAO extends AbstractDao<Product> {

    Product get(String url);

    void remove(String url);
}

