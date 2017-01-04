package ua.com.models.model;

import javax.persistence.*;

/**
 * Created by Max on 12/8/2016.
 */
@Entity
@Table(name = "sales")
public class SalePosition extends Model {

    /**
     * Товар текущей торговой позици.
     * Между объектами классов Product и SalePosition связь один-к-одному.
     * Выборка объекта product при первом доступе к текущему объекту.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    /**
     * Количество товаров в текущей торговой позиции.
     * Значение поля сохраняется в колонке "number". Не может быть null.
     */
    @Column(name = "number", nullable = false)
    private int number;

    /**
     * Заказ, к которому относится текущая торговая позиция
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    /**
     * Конструктр без параметров.
     */
    public SalePosition() {
       // this(null, 0);
    }

    /**
     * Конструктор для инициализации основных переменных категории.
     */
    public SalePosition(Product product, int number) {
        super();
        this.product = product;
        this.number = number;
    }

    /**
     * Возвращает описание торговой позиции.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SalePosition #" + getId() + ": ");
        sb.append("\n").append(this.product.getTitle()).append("\n№ ").append(this.product.getId())
                .append(", ").append(this.product.getPrice()).append(" UAH")
                .append("\nNumber = ").append(this.number)
                .append("\nPrice = ").append(getPrice());
        return sb.toString();
    }

    /**
     * Генерирует строку для конечного сравнения торговых позиций в методе equals() родительского класса.
     */
    @Override
    public String toEquals() {
        String line = this.product.toEquals();
        if (getId() != null) {
            line += getId();
        }
        return line;
    }

    /**
     * Возвращает общую стоимость торговой позиции (цена товара * количество).
     */
    public double getPrice() {
        return this.product.getPrice() * this.number;
    }

    /**
     * Увеличивает количество товаров в позиции на 1.
     */
    public void numberIncr() {
        this.number++;
    }

    /**
     * Возвращает товар текущей торговой позиции.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Устанавливает товар для текущей торговой позиции.
     */
    public void setProduct(Product product) {
        this.product = product;
        this.number = product != null ? 1 : 0;
    }

    /**
     * Возвращает количество товаров в торговой позиции.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Устанавливает номер торговой позиции.
     * Если входной параметр меньше 0, тогда значение номера будет 0.
     */
    public void setNumber(int number) {
        this.number = number > 0 ? number : 0;
    }

    /**
     * Возвращает заказ, которому пренадлежит текущая торговая позиция.
     */
    public Order getOrder() {
        return this.order;
    }

    /**
     * Устанавливает заказ, которому пренадлежит текущая торговая позиция.
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}

