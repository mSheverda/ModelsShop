package ua.com.models.repository;

import ua.com.models.model.Product;

public interface ProductRepository extends MainRepository<Product, Long> {

    Product findByUrl(String url);

    void deleteByUrl(String url);
}


