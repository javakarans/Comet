package ir.comet.bean;

import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/26/2017.
 */
@ManagedBean
@ViewScoped
public class UserPageBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    public void checkUserLogin(){
        if(userSessionBean.isUserLogin()){
            String currentURL = userSessionBean.getCurrentURL();
            try {
                System.out.println(currentURL);
                FacesContext.getCurrentInstance().getExternalContext().redirect(currentURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String redirectToRegisterPage(){
        return "registerPage.xhtml?faces-redirect=true";
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
