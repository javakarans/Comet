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

    private SqlHandler sqlHandler;

    public CustomerDaoImp(){
        sqlHandler=SqlHandler.getInstance();
    }

    public void createCustomer(Customer customer) {
        sqlHandler.create(customer);
    }

    public Customer getCustomer(long customerId) {
        return (Customer) sqlHandler.getObjectsBySpecialColumn(new Customer(),"customerId",customerId);
    }

    public Customer getCustomerByUserNameAndPass(String userName,String password) {
        return (Customer) sqlHandler.getObjectsBySpecialColumn
                (new Customer(),"userName",userName,"password",password).get(0);
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public void updateCustomer(Customer customer) {
        sqlHandler.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        sqlHandler.delete(customer);
    }
}
