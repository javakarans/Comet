package ir.comet.database;


import ir.comet.model.OrderDetail;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface OrderDao {

    public boolean createOrder(OrderDetail orderDetail);
    public OrderDetail getOrder(long orderId);
    public List<OrderDetail> getAllOrders();
    public boolean updateOrder(OrderDetail orderDetail);
    public boolean deleteOrder(OrderDetail orderDetail);

}
