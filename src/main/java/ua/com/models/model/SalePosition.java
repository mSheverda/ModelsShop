package ua.com.models.model;

import javax.persistence.*;

/**
 * Created by Max on 12/8/2016.
 */
@Entity
@Table(name = "sales")
public class SalePosition extends Model {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(name = "number", nullable = false)
    private int number;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    public SalePosition() {

    }

    public SalePosition(Product product, int number) {
        super();
        this.product = product;
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SalePosition #" + getId() + ": ");
        sb.append("\n").append(this.product.getTitle()).append("\n№ ").append(this.product.getId())
                .append(", ").append(this.product.getPrice()).append(" UAH")
                .append("\nNumber = ").append(this.number)
                .append("\nPrice = ").append(getPrice());
        return sb.toString();
    }

    @Override
    public String toEquals() {
        String line = this.product.toEquals();
        if (getId() != null) {
            line += getId();
        }
        return line;
    }

    public double getPrice() {
        return this.product.getPrice() * this.number;
    }

    public void numberIncr() {
        this.number++;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.number = product != null ? 1 : 0;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number > 0 ? number : 0;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

