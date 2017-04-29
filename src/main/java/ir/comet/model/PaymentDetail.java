package ir.comet.model;

import ir.comet.wrapper.UserProductCart;

import java.util.List;

/**
 * Created by Mohammad on 4/28/2017.
 */
public class PaymentDetail {

    private long customerId;
    private OrderDetail orderDetail;
    private Receipt receipt;
    private List<UserProductCart> userProductCartList;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public List<UserProductCart> getUserProductCartList() {
        return userProductCartList;
    }

    public void setUserProductCartList(List<UserProductCart> userProductCartList) {
        this.userProductCartList = userProductCartList;
    }
}
