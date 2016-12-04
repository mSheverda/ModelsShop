package ua.com.models.repository;

import ua.com.models.model.Product;

import java.util.List;

public interface ProductRepository extends MainRepository<Product, Long> {
    /**
     * Возвращает товар из базы данных, у которого совпадает параметр url.
     *
     */
    Product findByUrl(String url);

    /**
     * Возвращает товар из базы даных, у которого совпадает уникальный
     * артикль с значением входящего параметра.
     *
     * @return Объект класса {@link Product} - товара с уникальным артиклем.
     */
    Product findByArticle(int article);

    /**
     * Удаляет товар из базы данных, у которого совпадает параметр url.
     *
     */
    void deleteByUrl(String url);

    /**
     * Удаляет товар из базы данных, у которого совпадает параметр article.
     *
     */
    void deleteByArticle(int article);

    /**
     * Возвращает список товаров, которые пренадлежат категории
     * с уникальным кодом - входным параметром.
     *
     * @param id Код категории.
     */
    List<Product> findByCategoryId(long id);
}



