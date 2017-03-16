package ir.comet.database;


import ir.comet.model.Order;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface OrderDao {

    public void createOrder(Order order);
    public Order getOrder(long orderId);
    public List<Order> getAllOrders();
    public void updateOrder(Order order);
    public void deleteOrder(Order order);

}
