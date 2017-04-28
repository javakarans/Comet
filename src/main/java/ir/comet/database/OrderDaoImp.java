package ir.comet.database;

import ir.comet.model.Order;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class OrderDaoImp implements OrderDao {

    private SQLService SQLService;

    public OrderDaoImp(){
        SQLService =new SQLService();
    }

    public void createOrder(Order order) {
        SQLService.create(order);
    }

    public Order getOrder(long orderId) {
        return (Order) SQLService.getObjectsBySpecialColumn(this.getClass(), "orderId", orderId).get(0);
    }

    public List<Order> getAllOrders() {
        return null;
    }

    public void updateOrder(Order order) {
        SQLService.update(order);
    }

    public void deleteOrder(Order order) {
        SQLService.delete(order);
    }
}
