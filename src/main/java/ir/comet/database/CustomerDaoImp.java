package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Comment;
import ir.comet.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CustomerDaoImp implements CustomerDao {

    private SessionFactory sessionFactory;

    public CustomerDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createCustomer(Customer customer) {
        SqlHandler.create(customer);
    }

    public Customer getCustomer(long customerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("customerId",customerId));
        session.getTransaction().commit();
        List<Customer> list = criteria.list();
        session.close();
        sessionFactory.close();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public Customer getCustomerByUserNameAndPass(String userName,String password) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria
                .add(Restrictions.eq("userName",userName))
                .add(Restrictions.eq("password",password));
        session.getTransaction().commit();
        List<Customer> list = criteria.list();
        session.close();
        sessionFactory.close();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public void updateCustomer(Customer customer) {
        SqlHandler.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        SqlHandler.delete(customer);
    }
}
