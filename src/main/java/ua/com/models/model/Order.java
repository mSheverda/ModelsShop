package ua.com.models.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 12/8/2016.
 */
@Entity
@Table(name = "orders")
public class Order extends Model {

    private static final long serialVersionUID = 1L;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_details")
    private String shippingDetails;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private User manager;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<SalePosition> salePositions = new ArrayList<>();

    public Order() {
        super();
        this.shippingAddress = "";
        this.shippingDetails = "";
        this.description = "";
        this.number = createRandomString();
        this.date = dateToString(new Date());
    }

    public Order(Status status, User client, List<SalePosition> salePositions) {
        this();
        this.status = status;
        this.client = client;
        addSalePositions(salePositions);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number).append(", ")
                .append(this.status.getDescription()).append(",\n").append(this.date);

        if (this.client != null) {
            sb.append("\n\nClient: ").append(this.client.getName())
                    .append("\ne-mail: ").append(this.client.getEmail())
                    .append("\nphone: ").append(this.client.getPhone()).append("\n");
        }

        if (this.manager != null) {
            sb.append("\n").append(this.manager.getRole().getDescription())
                    .append(" ").append(this.manager.getName()).append("\n");
        }

        if (!this.shippingAddress.isEmpty()) {
            sb.append("\nShipping address: ").append(this.shippingAddress);
        }
        if (!this.shippingDetails.isEmpty()) {
            sb.append("\nShipping details: ").append(this.shippingDetails);
        }
        if (!this.description.isEmpty()) {
            sb.append("\nDescription: ").append(this.description);
        }

        if (this.salePositions != null && !this.salePositions.isEmpty()) {
            sb.append("\nSale Positions: ");
            int count = 1;
            for (SalePosition salePosition : this.salePositions) {
                sb.append("\n").append(count++).append(") ").append(salePosition.getProduct().getTitle())
                        .append(", № ").append(salePosition.getProduct().getId()).append(",\n")
                        .append(salePosition.getNumber()).append(" x ")
                        .append(salePosition.getProduct().getPrice()).append(" = ")
                        .append(salePosition.getPrice()).append(" UAH;");
            }
            sb.append("\n\nPRICE = ").append(getPrice()).append(" UAH");
        }
        return sb.toString();
    }

    @Override
    public String toEquals() {
        return getNumber();
    }

    public void initialize(String number, Date date, String shippingAddress, String shippingDetails,
                           String description, Status status, User client, User manager) {
        setNumber(number);
        setDate(date);
        setShippingAddress(shippingAddress);
        setShippingDetails(shippingDetails);
        setDescription(description);
        setStatus(status);
        setClient(client);
        setManager(manager);
    }

    public void addSalePosition(SalePosition salePosition) {
        this.salePositions.add(salePosition);
        if (salePosition.getOrder() != this) {
            salePosition.setOrder(this);
        }
    }

    public void addSalePositions(List<SalePosition> salePositions) {
        this.salePositions.addAll(salePositions);
        for (SalePosition salePosition : salePositions) {
            if (salePosition.getOrder() != this) {
                salePosition.setOrder(this);
            }
        }
    }

    public void removeSalePosition(SalePosition salePosition) {
        this.salePositions.remove(salePosition);
    }

    public void removeSalePositions(List<SalePosition> salePositions) {
        this.salePositions.removeAll(salePositions);
    }

    public void clearSalePositions() {
        this.salePositions.clear();
    }

    public List<SalePosition> getSalePositions() {
        return getUnmodifiableList(this.salePositions);
    }

    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
        for (SalePosition salePosition : this.salePositions) {
            if (salePosition.getOrder() != this) {
                salePosition.setOrder(this);
            }
        }
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number == null ? "" : number;
    }

    public void newNumber() {
        this.number = createRandomString();
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date != null ? dateToString(date) : "";
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getClient() {
        return this.client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getManager() {
        return this.manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress != null ? shippingAddress : "";
    }

    public String getShippingDetails() {
        return this.shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails != null ? shippingDetails : "";
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    public double getPrice() {
        double price = 0;
        for (SalePosition salePosition : this.salePositions) {
            price += salePosition.getPrice();
        }
        return price;
    }
}
