package ua.com.models.dao.impl;

/**
 * Created by Max on 11/27/2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.ProductDAO;
import ua.com.models.model.Product;
import ua.com.models.repository.ProductRepository;

import java.util.List;

@Repository
public class ProductDAOImpl extends AbstractDaoImpl<Product> implements ProductDAO
{
    /**
     * Реализация репозитория {@link ProductRepository} для работы с товаров базой данных.
     */
    private final ProductRepository repository;

    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
 
     */
    @Autowired
    public ProductDAOImpl(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Возвращает товар из базы данных, у которого совпадает параметр url.

     */
    @Override
    public Product getByUrl(String url) {
        return this.repository.findByUrl(url);
    }

    /**
     * Возвращает товар из базы даных, у которого совпадает уникальный
     * артикль с значением входящего параметра.

     */
    @Override
    public Product getByArticle(int article) {
        return this.repository.findByArticle(article);
    }

    /**
     * Удаляет товар из базы данных, у которого совпадает параметр url.

     */
    @Override
    public void removeByUrl(String url) {
        this.repository.deleteByUrl(url);
    }

    /**
     * Удаляет товар из базы данных, у которого совпадает параметр article.
     *
     */
    @Override
    public void removeByArticle(int article) {
        this.repository.deleteByArticle(article);
    }

    /**
     * Удаляет товары из базы даных, которые пренадлежат категории
     * с уникальным кодом - входным параметром.
     *
     */
    @Override
    public void removeByCategoryId(long id) {
        List<Product> productList = this.repository.findByCategoryId(id);
        this.repository.delete(productList);
    }

    /**
     * Возвращает список товаров, которые пренадлежат категории
     * с уникальным кодом - входным параметром.
     *

     */
    @Override
    public List<Product> getListByCategoryId(long id) {
        return this.repository.findByCategoryId(id);
    }

    public List<Product> search(String searchTerm)
    {
        return this.repository.search(searchTerm);
    }
    
}

