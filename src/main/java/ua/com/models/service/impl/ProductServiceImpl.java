package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.CategoryDAO;
import ua.com.models.dao.ProductDAO;

import ua.com.models.model.Category;
import ua.com.models.model.Product;
import ua.com.models.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("productService")
public class ProductServiceImpl extends MainServiceImpl<Product> implements ProductService {
    /**
     * Реализация интерфейса {@link ProductDAO} для работы с товаров базой данных.
     */
    private final ProductDAO productDAO;

    /**
     * Реализация интерфейса {@link CategoryDAO} для работы с категорий базой данных.
     */
    private final CategoryDAO categoryDAO;

    /**
     * Конструктор для инициализации основных переменных сервиса.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.

     */
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, CategoryDAO categoryDAO) {
        super(productDAO);
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    /**
     * Возвращает товар, у которого совпадает параметр url. Режим только для чтения.
     *

     */
    @Override
    @Transactional(readOnly = true)
    public Product getByUrl(String url)
    {
        Product product = this.productDAO.getByUrl(url);

        return product;
    }

    /**
     * Возвращает товар, у которого совпадает уникальный
     * артикль с значением входящего параметра. Режим только для чтения.
     *
     */
    @Override
    @Transactional(readOnly = true)
    public Product getByArticle(int article)
    {
        Product product = this.productDAO.getByArticle(article);
        return product;
    }

    /**
     * Возвращает список товаров, которые относятся к категории
     * с уникальным URL - входным параметром. Режим только для чтения.
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getByCategoryUrl(String url)
    {

        Category category = this.categoryDAO.get(url);

        return this.productDAO.getListByCategoryId(category.getId());
    }

    /**
     * Возвращает список товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром. Режим только для чтения.
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getByCategoryId(Long id)
    {

        return this.productDAO.getListByCategoryId(id);
    }

    /**
     * Возвращает список рандомных товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром.
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getRandomByCategoryId(int size, Long id) {
        return getRandomByCategoryId(size, id, -1L);
    }

    /**
     * Возвращает список рандомных товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром. Режим только для чтения.
     **/
    @Override
    @Transactional(readOnly = true)
    public List<Product> getRandomByCategoryId(int size, Long categoryId, Long differentProductId)
    {

        List<Product> products = this.productDAO.getListByCategoryId(categoryId);
        if (products.isEmpty()) {
            return new ArrayList<>();
        }
        products.remove(this.productDAO.get(differentProductId));
        return getShuffleSubList(products, 0, size);
    }

    /**
     * Возвращает список рандомных товаров. Режим только для чтения.
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getRandom(int size) {
        List<Product> products = this.productDAO.getAll();
        if (products.isEmpty()) {
            return new ArrayList<>();
        }
        return getShuffleSubList(products, 0, size);
    }

    /**
     * Удаляет товар, у которого совпадает параметр url.
     */
    @Override
    @Transactional
    public void removeByUrl(String url)
    {
        this.productDAO.removeByUrl(url);
    }

    /**
     * Удаляет товар, у которого совпадает параметр article.
     */
    @Override
    @Transactional
    public void removeByArticle(int article) {
        this.productDAO.removeByArticle(article);
    }

    /**
     * Удаляет товары, которые пренадлежат категории
     * с уникальным URL - входным параметром.
    */
    @Override
    @Transactional
    public void removeByCategoryUrl(String url)
    {
      Category category = this.categoryDAO.get(url);
      this.productDAO.removeByCategoryId(category.getId());
    }

    /**
     * Удаляет товары, которые пренадлежат категории
     * с уникальным кодом - входным параметром.
    */
    @Override
    @Transactional
    public void removeByCategoryId(Long id)
    {

        this.productDAO.removeByCategoryId(id);
    }

    /**
     * Возвращает список перемешаных товаров начиная с позиции start и заканчиваю позицеей end.
     *
     */
    private static List<Product> getShuffleSubList(List<Product> products, int start, int end) {
        if (products == null || products.isEmpty() || start > products.size() || start > end || start < 0 || end < 0) {
            return new ArrayList<>();
        }
        if (end > products.size()) {
            end = products.size();
        }
        Collections.shuffle(products);
        return products.subList(start, end);
    }

    @Override
    @Transactional
    public List<Product> searchProduct(String searchTerm)
    {
        return this.productDAO.search(searchTerm);
    }
}
