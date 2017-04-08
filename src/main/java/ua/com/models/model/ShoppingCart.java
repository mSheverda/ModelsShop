package ua.com.models.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Max on 12/10/2016.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<SalePosition> salePositions = new ArrayList<>();

    public ShoppingCart() {
        super();
    }

    public ShoppingCart(List<SalePosition> salePositions) {
        this();
        this.salePositions = salePositions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shoping Cart: ");
        if (this.salePositions != null && !this.salePositions.isEmpty()) {
            int count = 1;
            for (SalePosition salePosition : this.salePositions) {
                sb.append("\n").append(count++).append(") ").append(salePosition.getProduct().getTitle())
                        .append("\n№ ").append(salePosition.getProduct().getId())
                        .append(", ").append(salePosition.getPrice()).append(" UAH");
            }
            sb.append("\nPrice: ").append(getPrice()).append(" UAH");
        } else {
            sb.append("is empty!");
        }
        return sb.toString();
    }

    public void addSalePosition(SalePosition salePosition) {
        if (salePosition != null) {
            if (!this.salePositions.contains(salePosition)) {
                this.salePositions.add(salePosition);
            } else {
                int index = this.salePositions.indexOf(salePosition);
                this.salePositions.get(index).numberIncr();
            }
        }
    }

    public void addSalePositions(List<SalePosition> salePositions) {
        for (SalePosition salePosition : salePositions) {
            addSalePosition(salePosition);
        }
    }

    public SalePosition getSalePosition(long id) {
        SalePosition salePosition = this.salePositions.get((int)id);
        return salePosition;
    }

    public void removeSalePosition(long id) {
        SalePosition salePosition = getSalePosition(id); //this.salePositions.get((int)id);
        this.salePositions.remove(salePosition);
    }

    public void removeSalePositions(List<SalePosition> salePositions ) {
        this.salePositions.removeAll(salePositions);
    }

    public void clearSalePositions() {
        this.salePositions.clear();
    }

    public List<SalePosition> getSalePositions() {
        return this.salePositions == null || this.salePositions.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(this.salePositions);
    }

    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
    }

    public double getPrice() {
        double sum = 0;
        for (SalePosition salePosition : this.salePositions) {
            sum += salePosition.getPrice();
        }
        return sum;
    }

    public int getSize() {
        int size = 0;
        for (SalePosition salePosition : this.salePositions) {
            size += salePosition.getNumber();
        }
        return size;
    }


}