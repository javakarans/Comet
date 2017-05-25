package ir.comet.bean;


import ir.comet.database.OrderDaoImp;
import ir.comet.model.*;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrdersBean {

    private OrderDaoImp orderDaoImp;
    private List<OrderDetail> orderDetailList;
    private String orderStatus;
    private String onPending = Status.ON_PENDING;
    private String delivered = Status.DELIVERED;
    private String confirmed = Status.CONFIRMED;
    private String allStatus = Status.ALL_Status;
    private OrderDetail selectedOrderDetail;
    private String selectedStatus;
    private Customer selectedCustomer;
    private List<ProductOrderDetail> productOrderDetailList;

    @PostConstruct
    public void init()
    {
        orderDaoImp = new OrderDaoImp();
        orderDetailList = orderDaoImp.getAllOrders();
        selectedOrderDetail = new OrderDetail();
    }

    public void showCustomer(Customer customer)
    {
        this.selectedCustomer = customer;
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("$('#customerModal').modal()");
    }

    public void showProductList(List<ProductOrderDetail> productOrderDetailList)
    {
        this.productOrderDetailList = productOrderDetailList;
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("$('#productModal').modal()");

    }

    public void saveChangeStatus(OrderDetail orderDetail)
    {
        boolean result = orderDaoImp.updateOrder(orderDetail);
        if (result)
        {
            orderDetailList = orderDaoImp.getAllOrders();
        }
        else
        {
        }
    }

    public void changeList()
    {
        if (selectedStatus.equals(allStatus))
            orderDetailList = orderDaoImp.getAllOrders();
        else orderDetailList = orderDaoImp.getOrderByStatus(selectedStatus);
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOnPending() {
        return onPending;
    }

    public void setOnPending(String onPending) {
        this.onPending = onPending;
    }

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(String allStatus) {
        this.allStatus = allStatus;
    }

    public OrderDetail getSelectedOrderDetail() {
        return selectedOrderDetail;
    }

    public void setSelectedOrderDetail(OrderDetail selectedOrderDetail) {
        this.selectedOrderDetail = selectedOrderDetail;
    }

    public String getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<ProductOrderDetail> getProductOrderDetailList() {
        return productOrderDetailList;
    }

    public void setProductOrderDetailList(List<ProductOrderDetail> productOrderDetailList) {
        this.productOrderDetailList = productOrderDetailList;
    }
}
