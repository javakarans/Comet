package ir.comet.bean;

import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@SessionScoped
public class UserHeaderBean {

    private Customer customer;

    @PostConstruct
    public void init(){
        setCustomer(new Customer());
        loadUserSession();
    }

    public void loadUserSession() {
        Customer customer = (Customer) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("customer");
        this.setCustomer(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
