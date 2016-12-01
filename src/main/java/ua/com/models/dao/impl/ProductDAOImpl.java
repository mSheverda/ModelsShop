package ua.com.models.dao.impl;

/**
 * Created by Max on 11/27/2016.
 */

import ua.com.models.dao.ProductDAO;
import ua.com.models.repository.ProductRepository;
import ua.com.models.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl extends AbstractDaoImpl<Product> implements ProductDAO {

    private final ProductRepository repository;

    @Autowired
    public ProductDAOImpl(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Product get(String url) {
        return this.repository.findByUrl(url);
    }

    @Override
    public void remove(String name) {
        this.repository.deleteByUrl(name);
    }
}

