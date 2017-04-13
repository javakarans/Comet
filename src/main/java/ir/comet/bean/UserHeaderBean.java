package ir.comet.bean;

import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ViewScoped
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

    public void userAccountBtn(){

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("customer",customer);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../user/userAccount.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(){

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../comet.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
