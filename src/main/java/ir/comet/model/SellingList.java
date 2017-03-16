package ir.comet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amir on 2/27/2017.
 */

@Entity
@Table
public class SellingList implements Serializable {

    private  long sellingListId;
    private long productId;
    private long orderId;
    private int quantity;
    private long totalPrice;
    private long totalPriceAfterDiscountAndTax;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getSellingListId() {
        return sellingListId;
    }

    public void setSellingListId(long sellingListId) {
        this.sellingListId = sellingListId;
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
