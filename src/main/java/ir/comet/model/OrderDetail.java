package ir.comet.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammad on 2/27/2017.
 */
@Entity
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailId;
    private String trackingNumber;
    private String issueDate;
    private String deliveryDate;
    private long totalPrice;
    private long totalPriceAfterDiscountAndTax;
    private String status;
    private String paymentType;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "orderDetail")
    @Fetch(FetchMode.SUBSELECT)
    private List<ProductOrderDetail> productOrderDetails=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(List<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
