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
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Название статуса, может принимать одно из значений перечисления.
     * Значение поля сохраняется в колонке "title". Не может быть null.
     */
    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum title;

    /**
     * Описание статуса. Значение поля сохраняется в колонке "description".
     */
    @Column(name = "description")
    private String description;

    /**
     * Список заказов, которые имеют текущий статус.
     * К текущстатусу можно добраться через поле "status"
     * в объекте класса Order.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public Status() {
       // this(null, "");
    }

    /**
     * Конструктор для инициализации основных переменных заказа.
     */
    public Status(StatusEnum title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    /**
     * Возвращает описание статуса.
     * Переопределенный метод родительского класса Object.
     */
    @Override
    public String toString() {
        return "Title: " + this.title.name() + "\nDescription: " + this.description;
    }

    /**
     * Добавляет заказы в список текущего статуса.
     */
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    /**
     * Добавляет список заказов в список заказов orders.
     */
    public void addOrders(List<Order> orders) {
        this.orders.addAll(orders);
    }

    /**
     * Удаляет заказ из списка текущего статуса.
     */
    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    /**
     * Метод удаляет список заказов из списка orders.
     */
    public void removeOrders(List<Order> orders) {
        this.orders.removeAll(orders);
    }

    /**
     * Очищает список заказов текущего статуса.
     */
    public void clearOrders() {
        this.orders.clear();
    }

    /**
     * Конвертирует список заказов текущего статуса
     * в список только для чтений и возвращает его.
     */
    public List<Order> getOrders() {
        return getUnmodifiableList(this.orders);
    }

    /**
     * Устанавливает список заказов текущего статуса.
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Возвращает название статуса.
     */
    public StatusEnum getTitle() {
        return this.title;
    }

    /**
     * Устанавливает название статуса, которое может принимать одно из
     * значений перечисления StatusEnum.
     */
    public void setTitle(StatusEnum title) {
        this.title = title;
    }

    /**
     * Возвращает описание статуса.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Устанавливает описание статуса.
     */
    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }
}