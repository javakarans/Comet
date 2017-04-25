package ir.comet.bean;

import ir.comet.model.BranchDetails;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@SessionScoped
public class UserSessionBean {

    private Customer customer;

    @PostConstruct
    public void init(){
        loadCustomer();
    }

    public void loadCustomer(){
        customer=new Customer();
        this.customer= (Customer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
