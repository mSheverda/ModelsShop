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

    private final ProductDAO productDAO;

    private final CategoryDAO categoryDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, CategoryDAO categoryDAO) {
        super(productDAO);
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getByUrl(String url)
    {
        Product product = this.productDAO.getByUrl(url);

        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getByArticle(int article)
    {
        Product product = this.productDAO.getByArticle(article);
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getByCategoryUrl(String url)
    {

        Category category = this.categoryDAO.get(url);

        return this.productDAO.getListByCategoryId(category.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getByCategoryId(Long id)
    {

        return this.productDAO.getListByCategoryId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getRandomByCategoryId(int size, Long id) {
        return getRandomByCategoryId(size, id, -1L);
    }

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

    @Override
    @Transactional(readOnly = true)
    public List<Product> getRandom(int size) {
        List<Product> products = this.productDAO.getAll();
        if (products.isEmpty()) {
            return new ArrayList<>();
        }
        return getShuffleSubList(products, 0, size);
    }

    @Override
    @Transactional
    public void removeByUrl(String url)
    {
        this.productDAO.removeByUrl(url);
    }

    @Override
    @Transactional
    public void removeByArticle(int article) {
        this.productDAO.removeByArticle(article);
    }

    @Override
    @Transactional
    public void removeByCategoryUrl(String url)
    {
      Category category = this.categoryDAO.get(url);
      this.productDAO.removeByCategoryId(category.getId());
    }

    @Override
    @Transactional
    public void removeByCategoryId(Long id)
    {

        this.productDAO.removeByCategoryId(id);
    }

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
