package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
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
    private UIComponent component;
    private CustomerDaoImp customerDaoImp;

    @PostConstruct
    public void init(){
        customerDaoImp=new CustomerDaoImp();
        customer=new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String registerCustomer(){
        boolean customer = findCustomer(this.customer.getEmail());
        if(!customer){
            this.customer.setUserName(this.customer.getEmail());
            customerDaoImp.createCustomer(this.customer);
            userSessionBean.setUserSessionId(this.customer.getCustomerId());
            userSessionBean.setUserLogin(true);
            return "/comet.xhtml?faces-redirect=true";
        }else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("*این ایمیل قبلا ثبت شده است"));
            return "";
        }
    }

    public boolean findCustomer(String userName){
        Customer customer = customerDaoImp.getCustomerByUsername(userName);
        if(customer!=null){
            return true;
        }
        return false;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
}
