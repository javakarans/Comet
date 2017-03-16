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

    private SessionFactory sessionFactory;

    public OrderDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createOrder(Order order) {
        SqlHandler.create(order);
    }

    public Order getOrder(long orderId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Branch.class);
        criteria.add(Restrictions.eq("orderId",orderId));
        session.getTransaction().commit();
        session.close();
        List<Order> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return null;
    }

    public void updateOrder(Order order) {
        SqlHandler.update(order);
    }

    public void deleteOrder(Order order) {
        SqlHandler.delete(order);
    }
}
