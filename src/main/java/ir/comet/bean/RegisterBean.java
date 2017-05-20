package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
        customer=new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String registerCustomer(){
        customer.setUserName(customer.getEmail());
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customerDaoImp.createCustomer(customer);
        userSessionBean.setUserSessionId(customer.getCustomerId());
        userSessionBean.setUserLogin(true);
        return "/comet.xhtml?faces-redirect=true";
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
