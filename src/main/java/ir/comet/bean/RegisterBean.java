package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/9/2017.
 */
@ManagedBean
@ViewScoped
public class RegisterBean {

    private Customer customer;

    public RegisterBean(){
        customer=new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void registerCustomer(){

        String username=customer.getEmail();
        customer.setUserName(username);
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customerDaoImp.createCustomer(customer);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../comet.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
