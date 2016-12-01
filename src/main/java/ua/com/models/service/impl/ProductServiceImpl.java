package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.ProductDAO;

import ua.com.models.model.Product;
import ua.com.models.service.ProductService;


@Service("productService")
@Transactional
public class ProductServiceImpl extends MainServiceImpl<Product> implements ProductService {

    @Autowired
    private final ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        super(dao);
        this.dao = dao;
    }
}