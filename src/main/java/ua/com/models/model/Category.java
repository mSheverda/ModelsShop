package ua.com.models.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 12/3/2016.
 */
@Entity
@Table(name = "categories")
public class Category extends Model {
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Название категории. Значение поля сохраняется в колонке "title". Не может быть null.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * URL категории. Значение поля сохраняется в колонке "url". Не может быть null.
     */
    @Column(name = "url", nullable = false)
    private String url;

    /**
     * Описание категории. Значение поля сохраняется в колонке "description".
     */
    @Column(name = "description")
    private String description;

    /**
     * Изображение категории.
     * Значение поля (id объекта photo) сохраняется в колонке "photo_id".
     * Между объектами связь один-к-одному, а именно каждая
     * запись в одной таблице напрямую связана с отдельной записью в другой таблице.
     * Выборка объекта photo до первого доступа нему, при первом доступе к текущему объекту.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    /**
     * Список товаров, которые относятся к данной категории.
     * К текущей категории можно добраться через поле "category"
     * в объекте класса Category.
     * Выборка объектов products при первом доступе к нему.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public Category() {
        this("", "", "", null);
    }

    /**
     * Конструктор для инициализации основных переменных категории.
     *
     */
    public Category(String title, String url, String description, Photo photo) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.photo = photo;
    }

    /**
     * Возвращает описание категории.
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTitle: ").append(this.title)
                .append("\nUrl: ").append(this.url)
                .append("\nDiscription: ").append(this.description);
        return sb.toString();
    }

    /**
     * Генерирует строку для конечного сравнения категорий в методе equals() родительского класса.

     */
    @Override
    public String toEquals() {
        if (this.title.isEmpty() || this.url.isEmpty()) {
            return super.toString();
        } else {
            return getTitle() + getUrl();
        }
    }

    /**
     * Инициализация полей категории.

     */
    public void initialize(String title, String url, String description, Photo photo) {
        setTitle(title);
        setUrl(url);
        setDescription(description);
        setPhoto(photo);
    }

    /**
     * Добавляет товар в список текущей категории.
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Добавляет список товаров в список текущей категории.

     */
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    /**
     * Удаляет товар из списка текущей категории.
   */
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    /**
     * Удаляет список товаров из списка текущей категории.
     */
    public void removeProducts(List<Product> products) {
        this.products.removeAll(products);
    }

    /**
     * Очищает список товаров products.
     */
    public void clearProducts() {
        this.products.clear();
    }

    /**
     * Конвертирует список товаров products данной категории
     * в список только для чтений и возвращает его.
     */
    public List<Product> getProducts() {
        return getUnmodifiableList(this.products);
    }

    /**
     * Устанавливает список товаров products,
     * которые будут относиться к данной категории.
    */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Возвращает название категории.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Устанавливает название категории.
     */
    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }

    /**
     * Возвращает URL категории.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Устанавливает URL категории.
     */
    public void setUrl(String url) {
        this.url = url == null ? "" : url;
    }

    /**
     * Возвращает описание категории.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Устанавливает описание категории.
     */
    public void setDescription(String description) {
        this.description = description == null ? "" : description;
    }

    /**
     * Возвращает изображение категории.
     */
    public Photo getPhoto() {
        return this.photo;
    }

    /**
     * Устанавливает изображение категории.
    */
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}