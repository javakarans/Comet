package ir.comet.database;

import ir.comet.model.Customer;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CustomerDaoImp implements CustomerDao {

    private SQLService sqlService;

    public CustomerDaoImp(){
        sqlService =new SQLService();
    }

    public void createCustomer(Customer customer) {
        sqlService.create(customer);
    }

    public Customer getCustomer(long customerId) {
        return (Customer) sqlService.getObjectsBySpecialColumn(new Customer(),"customerId",customerId).get(0);
    }

    public Customer getCustomerByUserNameAndPass(String userName,String password) {
        List customer = sqlService.getObjectsBySpecialColumn
                (new Customer(), "userName", userName, "password", password);
        if(!customer.isEmpty()){
            return (Customer) customer.get(0);
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return sqlService.getAllObjects(new Customer());
    }

    public void updateCustomer(Customer customer) {
        sqlService.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        sqlService.delete(customer);
    }

}
