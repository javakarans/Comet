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

    private LoginController loginController;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
        loginController=new LoginController();
    }

    public String login(){
        Customer customer = loginController.customerLogin();
        if(customer!=null){
            userSessionBean.setCustomer(customer);
        }
        return "/comet.xhtml?faces-redirect=true";
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
