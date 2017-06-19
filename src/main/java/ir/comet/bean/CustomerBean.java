package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {

    private CustomerDaoImp customerDaoImp;
    private List<Customer> customerList;

    @PostConstruct
    public void init()
    {
        customerDaoImp = new CustomerDaoImp();
        customerList = customerDaoImp.getAllCustomers();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
