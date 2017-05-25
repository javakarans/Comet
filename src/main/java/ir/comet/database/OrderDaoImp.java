package ir.comet.database;

import ir.comet.model.OrderDetail;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class OrderDaoImp implements OrderDao {

    private SQLService sqlService;

    public OrderDaoImp(){
        sqlService =new SQLService();
    }

    public boolean createOrder(OrderDetail orderDetail) {
        return sqlService.create(orderDetail);
    }

    public OrderDetail getOrder(long orderId) {
        List result = sqlService.getObjectsBySpecialColumn(new OrderDetail(),"orderDetailId", orderId);
        if (result.isEmpty()) return null;
        else return (OrderDetail) result.get(0);
    }

    public List<OrderDetail> getOrderByStatus(String status)
    {
        return sqlService.getObjectsBySpecialColumn(new OrderDetail(),"status",status);
    }

    public List<OrderDetail> getAllOrders() {
        return sqlService.getAllObjects(new OrderDetail());
    }

    public boolean updateOrder(OrderDetail orderDetail) {
        return sqlService.update(orderDetail);
    }

    public boolean deleteOrder(OrderDetail orderDetail) {
        return sqlService.delete(orderDetail);
    }
}
