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

    private static final long serialVersionUID = 1L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Category() {
        this("", "", "", null);
    }

    public Category(String title, String url, String description, Photo photo) {
        super();
        this.title = title;
        this.url = url;
        this.description = description;
        this.photo = photo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTitle: ").append(this.title)
                .append("\nUrl: ").append(this.url)
                .append("\nDiscription: ").append(this.description);
        return sb.toString();
    }

    @Override
    public String toEquals() {
        if (this.title.isEmpty() || this.url.isEmpty()) {
            return super.toString();
        } else {
            return getTitle() + getUrl();
        }
    }

     public void initialize(String title, String url, String description, Photo photo) {
        setTitle(title);
        setUrl(url);
        setDescription(description);
        setPhoto(photo);
    }


    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void removeProducts(List<Product> products) {
        this.products.removeAll(products);
    }


    public void clearProducts() {
        this.products.clear();
    }

    public List<Product> getProducts() {
        return getUnmodifiableList(this.products);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url == null ? "" : url;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}