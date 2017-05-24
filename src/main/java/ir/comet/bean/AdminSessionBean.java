package ir.comet.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by amir on 5/24/2017.
 */

@ManagedBean
@SessionScoped
public class AdminSessionBean {

    private boolean login = false;

    @PostConstruct
    private void init()
    {

    }

    public void checkAdminLogin()
    {
        if(!login){
            String redirectUrl = redirectToCometPage();
            try {
                System.out.println(redirectUrl);
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String redirectToCometPage(){
        return "../comet.xhtml?faces-redirect=true";
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
