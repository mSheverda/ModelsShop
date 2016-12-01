package ua.com.models.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product  extends Model{

    @Column(name = "product_name")
    private String url;
    private int year;

    public Product() {

    }

    public Product(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}