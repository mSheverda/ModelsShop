package ua.com.models.model;

import ua.com.models.enums.StatusEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 12/9/2016.
 */
@Entity
@Table(name = "statuses")
public class Status extends Model {

    private static final long serialVersionUID = 1L;

    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum title;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();

    public Status() {

    }

    public Status(StatusEnum title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + this.title.name() + "\nDescription: " + this.description;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addOrders(List<Order> orders) {
        this.orders.addAll(orders);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    public void removeOrders(List<Order> orders) {
        this.orders.removeAll(orders);
    }

    public void clearOrders() {
        this.orders.clear();
    }

    public List<Order> getOrders() {
        return getUnmodifiableList(this.orders);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public StatusEnum getTitle() {
        return this.title;
    }

    public void setTitle(StatusEnum title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }
}