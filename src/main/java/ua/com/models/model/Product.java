package ua.com.models.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends Model {

    private static final long serialVersionUID = 1L;

    public static final char[] CODE_PATTERN = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static final int CODE_LENGTH = 5;

    @Column(name = "article", nullable = false)
    private int article;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "scale")
    private String scale;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "num_of_details")
    private String details;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    @Column(name = "price", nullable = false)
    private double price;


      @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.REMOVE)
      private List<SalePosition> salePositions = new ArrayList<>();

    public Product() {

    }

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

    @Override
    public String toEquals() {
        return getArticle() + getTitle() + getUrl() + getDifficulty() + getManufacturer() +
        getScale() + getDetails()+ getPrice();
    }

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

    public int getArticle() {
        return this.article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title != null ? title : "";
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url != null ? url : "";
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }

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