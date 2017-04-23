package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Comment;
import ir.comet.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class OrderDaoImp implements OrderDao {

    private SqlHandler sqlHandler;

    public OrderDaoImp(){
        sqlHandler=SqlHandler.getInstance();
    }

    public void createOrder(Order order) {
        sqlHandler.create(order);
    }

    public Order getOrder(long orderId) {
        return (Order) sqlHandler.getObjectsBySpecialColumn(this.getClass(), "orderId", orderId).get(0);
    }

    public List<Order> getAllOrders() {
        return null;
    }

    public void updateOrder(Order order) {
        sqlHandler.update(order);
    }

    public void deleteOrder(Order order) {
        sqlHandler.delete(order);
    }
}
