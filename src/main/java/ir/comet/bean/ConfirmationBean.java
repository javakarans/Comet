package ir.comet.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mohammad on 5/20/2017.
 */
@ManagedBean
@ViewScoped
public class ConfirmationBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
        userSessionBean.setCurrentURL("/user/confirmationPage.xhtml");
    }

    public String getTrackNumber(){
        return userSessionBean.getProductOrderDetailList().get(0).getOrderDetail().getTrackingNumber();
    }

    public String redirectToAccountPage(){
        userSessionBean.reloadProductOrderDetailList();
        return "/user/userAccount.xhtml";
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
