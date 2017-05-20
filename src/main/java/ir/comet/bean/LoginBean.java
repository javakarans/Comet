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

    public void userLogin(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        Customer customer = customerDaoImp.getCustomerByUserNameAndPass(userName, password);
        System.out.println(customer.getCustomerId());
        if (customer!=null){
            userSessionBean.setUserSessionId(customer.getCustomerId());
            userSessionBean.setUserLogin(true);
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
}
