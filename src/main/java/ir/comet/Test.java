package ir.comet;

import ir.comet.Utilities.TrackNumber;
import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Mohammad on 5/20/2017.
 */
public class Test {

    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setEmail("good");
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customerDaoImp.createCustomer(customer);
    }
}
