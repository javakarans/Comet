package ir.comet.bean;

import ir.comet.controller.LoginController;
import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import java.io.IOException;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ViewScoped
public class LoginBean {

    private String userName;
    private String password;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private UIComponent component;

    public void userLogin(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        Customer customer = customerDaoImp.getCustomerByUserNameAndPass(userName, password);
        if (customer!=null){
            userSessionBean.setUserSessionId(customer.getCustomerId());
            userSessionBean.setUserLogin(true);
        }else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("*نام کاربری یا کلمه عبور اشتباه است"));
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
