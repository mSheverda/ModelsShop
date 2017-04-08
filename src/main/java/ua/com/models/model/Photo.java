package ua.com.models.model;

import javax.persistence.*;

/**
 * Created by Max on 12/3/2016.
 */

@Entity
@Table(name = "photos")
public class Photo extends Model {

    private static final long serialVersionUID = 1L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "photo_link_short")
    private String photoLinkShort;

    @Column(name = "photo_link_long")
    private String photoLinkLong;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "photo")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "photo")
    private Category category;

    public Photo() {
        this("", "", "");
    }

    public Photo(String title, String photoLinkShort, String photoLinkLong) {
        super();
        this.title = title;
        this.photoLinkShort = photoLinkShort;
        this.photoLinkLong = photoLinkLong;
    }

    public Photo(String title, String photoLinkShort) {
        this(title, photoLinkShort, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTitle: ").append(this.title)
                .append("\nphoto short link: ").append(this.photoLinkShort)
                .append("\nphoto long link: ").append(this.photoLinkLong);
        return sb.toString();
    }

    public void initialize(String title, String photoLinkShort, String photoLinkLong) {
        setTitle(title);
        setPhotoLinkShort(photoLinkShort);
        setPhotoLinkLong(photoLinkLong);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title != null ? title : "";
    }

    public String getPhotoLinkShort() {
        return this.photoLinkShort;
    }

    public void setPhotoLinkShort(String photoLinkShort) {
        this.photoLinkShort = photoLinkShort != null ? photoLinkShort : "";
    }

    public String getPhotoLinkLong() {
        return this.photoLinkLong;
    }

    public void setPhotoLinkLong(String photoLinkLong) {
        this.photoLinkLong = photoLinkLong != null ? photoLinkLong : "";
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

