package ua.com.models.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends Model {
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Набор вожможных для использованния символов по-умолчанию.
     */
    public static final char[] CODE_PATTERN = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    /**
     * Длина возвращаемой строки по-умолчанию
     */
    public static final int CODE_LENGTH = 5;

    /**
     * Артикль товара. Значение поля сохраняется в колонке "article". Не может быть null.
     */
    @Column(name = "article", nullable = false)
    private int article;

    /**
     * Название товара. Значение поля сохраняется в колонке "title". Не может быть null.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * URL товара. Значение поля сохраняется в колонке "url". Не может быть null.
     */
    @Column(name = "url", nullable = false)
    private String url;

    /**
     * Масштаб товара. Значение поля сохраняется в колонке "scale".
     */
    @Column(name = "scale")
    private String scale;

    /**
     * Производитель. Значение поля сохраняется в колонке "manufacturer".
     */
    @Column(name = "manufacturer")
    private String manufacturer;

    /**
     * Уровень сложности. Значение поля сохраняется в колонке "difficulty".
     */
    @Column(name = "difficulty")
    private String difficulty;

    /**
     * Количество деталей. Значение поля сохраняется в колонке "num_of_details".
     */
    @Column(name = "num_of_details")
    private String details;

    /**
     * Описание товара. Значение поля сохраняется в колонке "description".
     */
    @Column(name = "description")
    private String description;

    /**
     * Категория товара.
     * Значение поля (id объекта category) сохраняется в колонке "category_id". Не может быть null.
     * Между объектами классов Product и
     * Category связь многие-к-одному, а именно каждая
     * много заказов могут иметь одинаковый статус выполнения.
     * Выборка объекта category до первого доступа нему, при первом доступе к текущему объекту.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    /**
     * Изображение товара.
     * Значение поля (id объекта photo) сохраняется в колонке "photo_id".
     * Между объектами классов  Category и
     * Photo связь один-к-одному, а именно каждая
     * запись в одной таблице напрямую связана с отдельной записью в другой таблице.
     * Выборка объекта photo до первого доступа нему, при первом доступе к текущему объекту.
     * Сущности связаны полностью каскадным обновлением записей в базе данных.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    /**
     * Цена товара. Значение поля сохраняется в колонке "description". Не может быть null.
     */
    @Column(name = "price", nullable = false)
    private double price;


      @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
      private List<SalePosition> salePositions = new ArrayList<>();

    /**
     * Конструктр без параметров.

     */
    public Product() {

    }

    /**
     * Конструктор для инициализации основных переменных товара.

     */
    public Product( String title,
                   String url,
                   String scale,
                   String manufacturer,
                   String difficulty,
                   String details,
                   String description,
                   Category category,
                   Photo photo,
                   double price
    ) {
        super();
        this.title = title;
        this.url = url;
        this.scale = scale;
        this.manufacturer = manufacturer;
        this.difficulty = difficulty;
        this.details = details;
        this.description = description;
        this.category = category;
        this.photo = photo;
        this.price = price;

    }

    /**
     * Возвращает описание товара.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.title)
                .append("\nScale: ").append(this.scale)
                .append("\nManufacturer: ").append(this.manufacturer)
                .append("\nDifficulty: ").append(this.difficulty)
                .append("\nDetails: ").append(this.details)
                .append("\nDescription: ").append(this.description)
                .append("\nPrice = ").append(this.price).append(" UAH");

        if (this.category != null) {
            sb.append("\nCategory: ").append(this.category.getTitle());
        }
        return sb.toString();
    }

    /**
     * Генерирует строку для конечного сравнения товаров в методе equals() родительского класса.
     * Переопределенный метод родительского класса Model.
     */
    @Override
    public String toEquals() {
        return getArticle() + getTitle() + getUrl() + getDifficulty() + getManufacturer() +
        getScale() + getDetails()+ getPrice();
    }

    /**
     * Инициализация полей товара.
     */
    public void initialize(String title, String url, String details, String manufacturer, String difficulty,
                           String scale, String description, Category category, Photo photo, double price) {
        setTitle(title);
        setUrl(url);
        setDetails(details);
        setManufacturer(manufacturer);
        setDifficulty(difficulty);
        setScale(scale);
        setDescription(description);
        setCategory(category);
        setPhoto(photo);
        setPrice(price);
        setArticle(Integer.parseInt(createRandomString(CODE_PATTERN, CODE_LENGTH)));
    }

    /**
     * Генерирует новый артикль товара

     public void newArticle() {
        this.article = Integer.parseInt(createRandomString(CODE_PATTERN, CODE_LENGTH));
    }
    */

    /**
     * Возвращает артикль товара.
     */
    public int getArticle() {
        return this.article;
    }

    /**
     * Устанавливает артикль товара
     */
    public void setArticle(int article) {
        this.article = article;
    }

    /**
     * Возвращает название товара
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Устанавливает название товара
     */
    public void setTitle(String title) {
        this.title = title != null ? title : "";
    }

    /**
     * Возвращает URL товара.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Устанавливает URL товара
     */
    public void setUrl(String url) {
        this.url = url != null ? url : "";
    }

    /**
     * Возвращает описание товара.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Устанавливает описание товара
     */
    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    /**
     * Возвращает изображение товара
     */
    public Photo getPhoto() {
        return this.photo;
    }

    /**
     * Устанавливает изображение товара
     */
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    /**
     * Возвращает категорию товара
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Устанавливает категорию товара
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Возвращает цену товара
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Устанавливает цену товара
     */
    public void setPrice(double price) {
        this.price = price > 0 ? price : 0;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}