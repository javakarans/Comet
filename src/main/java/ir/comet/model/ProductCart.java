package ir.comet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amir on 2/27/2017.
 */

@Entity
@Table
public class ProductCart implements Serializable {

    private long productCartId;
    private long productId;
    private long orderId;
    private int quantity;
    private long totalPrice;
    private long totalPriceAfterDiscountAndTax;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getProductCartId() {
        return productCartId;
    }

    public void setProductCartId(long productCartId) {
        this.productCartId = productCartId;
    }

    @Column
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column
    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column
    public long getTotalPriceAfterDiscountAndTax() {
        return totalPriceAfterDiscountAndTax;
    }

    public void setTotalPriceAfterDiscountAndTax(long totalPriceAfterDiscountAndTax) {
        this.totalPriceAfterDiscountAndTax = totalPriceAfterDiscountAndTax;
    }

    @Column
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Column
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
