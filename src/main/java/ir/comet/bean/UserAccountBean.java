package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ViewScoped
public class UserAccountBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private Customer customer;

    @PostConstruct
    public void init(){
        loadUserData();
    }

    public void loadUserData(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customer=customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
