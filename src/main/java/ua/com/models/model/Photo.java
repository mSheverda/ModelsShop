package ua.com.models.model;

import javax.persistence.*;

/**
 * Created by Max on 12/3/2016.
 */

@Entity
@Table(name = "photos")
public class Photo extends Model {
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Название изображения. Значение поля сохраняется в колонке "title". Не может быть null.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Строка-ссылка на малое изображения. Значение поля сохраняется в колонке "photo_link_short".
     */
    @Column(name = "photo_link_short")
    private String photoLinkShort;

    /**
     * Строка-ссылка на большое изображения. Значение поля сохраняется в колонке "photo_link_long".
     */
    @Column(name = "photo_link_long")
    private String photoLinkLong;

    /**
     * Товар, к которому относится данное изображение. К даному объекту можно добраться
     * через поле "photo" в объекте класса Product.
     * Выборка объекта product при первом доступе к нему.
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "photo")
    private Product product;

    /**
     * Категория, к которой относится данное изображение. К текущему изображению можно добраться
     * через поле "photo" в объекте класса Category.
     * Выборка объекта category при первом доступе к нему.
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "photo")
    private Category category;

    /**
     * Конструктр без параметров.
     */
    public Photo() {
        this("", "", "");
    }

    /**
     * Конструктор для инициализации основных переменных изображения.
     */
    public Photo(String title, String photoLinkShort, String photoLinkLong) {
        super();
        this.title = title;
        this.photoLinkShort = photoLinkShort;
        this.photoLinkLong = photoLinkLong;
    }

    /**
     * Конструктор для инициализации переменных изображения.
     */
    public Photo(String title, String photoLinkShort) {
        this(title, photoLinkShort, "");
    }

    /**
     * Возвращает описание изображения.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTitle: ").append(this.title)
                .append("\nphoto short link: ").append(this.photoLinkShort)
                .append("\nphoto long link: ").append(this.photoLinkLong);
        return sb.toString();
    }

    /**
     * Инициализация полей изображения.
     */
    public void initialize(String title, String photoLinkShort, String photoLinkLong) {
        setTitle(title);
        setPhotoLinkShort(photoLinkShort);
        setPhotoLinkLong(photoLinkLong);
    }

    /**
     * Возвращает название изображения.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Устанавливает название изображения.
     */
    public void setTitle(String title) {
        this.title = title != null ? title : "";
    }

    /**
     * Возвращает строку-ссылка на малое изображения.
     */
    public String getPhotoLinkShort() {
        return this.photoLinkShort;
    }

    /**
     * Устанавливает строку-ссылка на малое изображения.
     */
    public void setPhotoLinkShort(String photoLinkShort) {
        this.photoLinkShort = photoLinkShort != null ? photoLinkShort : "";
    }

    /**
     * Возвращает строку-ссылка на большое изображения.
     */
    public String getPhotoLinkLong() {
        return this.photoLinkLong;
    }

    /**
     * Устанавливает строку-ссылка на большое изображения.
     */
    public void setPhotoLinkLong(String photoLinkLong) {
        this.photoLinkLong = photoLinkLong != null ? photoLinkLong : "";
    }

    /**
     * Возвращает товар, к которому относится данное изображение.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Устанавлевает товар, к которому будет относиться данное изображение.
     *
     * @param product Товар, к которому будет относиться данное изображение.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Возвращает категорию, к которой относится данное изображение.
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Устанавлевает категорию, которой будет пренадлежать данное изображение.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}

