package ua.com.models.dao;


import ua.com.models.model.Product;

import java.util.List;

public interface ProductDAO extends AbstractDao<Product> {

    Product getByUrl(String url);

    Product getByArticle(int article);

    void removeByUrl(String url);

    void removeByArticle(int article);

    void removeByCategoryId(long id);

    List<Product> getListByCategoryId(long id);

    List<Product> search(String searchTerm);

}
