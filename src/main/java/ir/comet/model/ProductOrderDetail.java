package ir.comet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amir on 2/27/2017.
 */

@Entity
public class ProductOrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productCartId;
    private int quantity;
    private long totalPrice;
    private long totalPriceAfterDiscountAndTax;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "orderDetailId")
    private OrderDetail orderDetail;

    public long getProductCartId() {
        return productCartId;
    }

    public void setProductCartId(long productCartId) {
        this.productCartId = productCartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalPriceAfterDiscountAndTax() {
        return totalPriceAfterDiscountAndTax;
    }

    public void setTotalPriceAfterDiscountAndTax(long totalPriceAfterDiscountAndTax) {
        this.totalPriceAfterDiscountAndTax = totalPriceAfterDiscountAndTax;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
