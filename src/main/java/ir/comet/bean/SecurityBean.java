package ir.comet.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 5/15/2017.
 */
@ManagedBean
@RequestScoped
public class SecurityBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private String loginURL="/user/user.xhtml";

    public void checkLogIn(){
        if(userSessionBean==null || !userSessionBean.isUserLogin()){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(loginURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
