package ir.comet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 2/27/2017.
 */

@Entity
@Table
public class Receipt implements Serializable {

    private long receiptId;
    private long trackingNumber;
    private String issueDate;
    private double totalPrice;
    private String deliveryDate;
    private long totalPriceAfterDiscountAndTax;
    private String paymentType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    @Column
    public long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Column
    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Column
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column
    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Column
    public long getTotalPriceAfterDiscountAndTax() {
        return totalPriceAfterDiscountAndTax;
    }

    public void setTotalPriceAfterDiscountAndTax(long totalPriceAfterDiscountAndTax) {
        this.totalPriceAfterDiscountAndTax = totalPriceAfterDiscountAndTax;
    }

    @Column
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
