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
    /**
     * Номер версии класса необходимый для десериализации и сериализации.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Список торговых позиций, которые сделал клиент, но пока не оформил заказ.
     */
    private List<SalePosition> salePositions = new ArrayList<>();

    /**
     * Конструктр без параметров.
     */
    public ShoppingCart() {
        super();
    }

    /**
     * Конструктор для инициализации основных переменных корзины.
     */
    public ShoppingCart(List<SalePosition> salePositions) {
        this();
        this.salePositions = salePositions;
    }

    /**
     * Возвращает описание корзины.
     * Переопределенный метод родительского класса Object.
     */
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

    /**
     * Добавляет торговую позицию в список корзины.
     */
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

    /**
     * Добавляет список торговых позиций в список корзины.
     */
    public void addSalePositions(List<SalePosition> salePositions) {
        for (SalePosition salePosition : salePositions) {
            addSalePosition(salePosition);
        }
    }

    /**
    * Возвращает торговую позицию из корзины.
    */

    public SalePosition getSalePosition(long id) {
        SalePosition salePosition = this.salePositions.get((int)id);
        return salePosition;
    }

    /**
     * Удаляет торговую позицию из корзины.
     */
    public void removeSalePosition(long id) {
        SalePosition salePosition = getSalePosition(id); //this.salePositions.get((int)id);
        this.salePositions.remove(salePosition);
    }

    /**
     * Удаляет список торговых позицый из корзины.
     */
    public void removeSalePositions(List<SalePosition> salePositions ) {
        this.salePositions.removeAll(salePositions);
    }

    /**
     * Очищает корзину. Удаляет все торговые позиции в корзине.
     */
    public void clearSalePositions() {
        this.salePositions.clear();
    }

    /**
     * Возвращает список всех торговых позиций в корзине.
     * Метод конвертирует список торговых позиций в корзине в список только для чтений и возвращает его.
     */
    public List<SalePosition> getSalePositions() {
        return this.salePositions == null || this.salePositions.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(this.salePositions);
    }

    /**
     * Устанавливает список торговых позиций.
     */
    public void setSalePositions(List<SalePosition> salePositions) {
        this.salePositions = salePositions;
    }

    /**
     * Возвращает цену корзины - цена всех торговых позиций.
     */
    public double getPrice() {
        double sum = 0;
        for (SalePosition salePosition : this.salePositions) {
            sum += salePosition.getPrice();
        }
        return sum;
    }

    /**
     * Возвращает размер корзины - количество товаров в корзине.
     */
    public int getSize() {
        int size = 0;
        for (SalePosition salePosition : this.salePositions) {
            size += salePosition.getNumber();
        }
        return size;
    }


}