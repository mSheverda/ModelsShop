package ua.com.models.service;


import ua.com.models.model.Product;

import java.util.List;

public interface ProductService extends MainService<Product> {
    /**
     * Возвращает товар, у которого совпадает параметр url.
     *

     */
    Product getByUrl(String url);

    /**
     * Возвращает товар, у которого совпадает уникальный
     * артикль с значением входящего параметра.
     *

     */
    Product getByArticle(int article);

    /**
     * Возвращает список товаров, которые относятся к категории
     * с уникальным URL - входным параметром.
     *

     */
    List<Product> getByCategoryUrl(String url);

    /**
     * Возвращает список товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром.
     *

     */
    List<Product> getByCategoryId(Long id);

    /**
     * Возвращает список рандомных товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром.
     *

     */
    List<Product> getRandomByCategoryId(int size, Long categoryId, Long differentProductId);

    /**
     * Возвращает список рандомных товаров, которые относятся к категории
     * с уникальным кодом id - входным параметром.
     *

     */
    List<Product> getRandomByCategoryId(int size, Long id);

    /**
     * Возвращает список рандомных товаров.
     *

     */
    List<Product> getRandom(int size);

    /**
     * Удаляет товар, у которого совпадает параметр url.

     */
    void removeByUrl(String url);

    /**
     * Удаляет товар, у которого совпадает параметр article.

     */
    void removeByArticle(int article);

    /**
     * Удаляет товары, которые пренадлежат категории с уникальным URL - входным параметром.
     */
    void removeByCategoryUrl(String url);

    /**
     * Удаляет товары, которые пренадлежат категории с уникальным кодом - входным параметром.
     *
     */
    void removeByCategoryId(Long id);


    List<Product> searchProduct(String searchTerm);

}
