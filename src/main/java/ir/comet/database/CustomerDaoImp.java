package ir.comet.database;

import ir.comet.model.Customer;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CustomerDaoImp implements CustomerDao {

    private SQLService SQLService;

    public CustomerDaoImp(){
        SQLService =new SQLService();
    }

    public void createCustomer(Customer customer) {
        SQLService.create(customer);
    }

    public Customer getCustomer(long customerId) {
        return (Customer) SQLService.getObjectsBySpecialColumn(new Customer(),"customerId",customerId);
    }

    public Customer getCustomerByUserNameAndPass(String userName,String password) {
        return (Customer) SQLService.getObjectsBySpecialColumn
                (new Customer(),"userName",userName,"password",password).get(0);
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public void updateCustomer(Customer customer) {
        SQLService.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        SQLService.delete(customer);
    }

}
