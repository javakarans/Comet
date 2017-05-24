package ir.comet.bean;


import ir.comet.database.OrderDaoImp;
import ir.comet.model.OrderDetail;

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

    @PostConstruct
    public void init()
    {
        orderDaoImp = new OrderDaoImp();
        orderDetailList = orderDaoImp.getAllOrders();
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
}
