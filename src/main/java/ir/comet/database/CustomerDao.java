package ir.comet.database;

import ir.comet.model.Customer;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface CustomerDao {

    public void createCustomer(Customer customer);
    public Customer getCustomer(long customerId);
    public Customer getCustomerByUserNameAndPass(String userName,String password);
    public List<Customer> getAllCustomers();
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);

}
