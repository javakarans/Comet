package ir.comet.bean;

import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.model.Customer;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ViewScoped
public class HeaderBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
    }

    public String redirectToUserAccount(){
        return "/user/userAccount.xhtml?faces-redirect=true";
    }

    public void logout(){
        userSessionBean.invalidUserSession();
    }

    public String redirectToProductPage(long branchId,long brandId){
        BranchDetailsDaoImp branchDetailsDaoImp=new BranchDetailsDaoImp();
        BranchDetailsWrapper branchDetailsWrapper=new BranchDetailsWrapper
                (branchDetailsDaoImp.getBranchDetails(branchId,brandId).get(0));
        userSessionBean.setBranchDetailsWrapper(branchDetailsWrapper);
        return "/user/Product.xhtml?faces-redirect=true";
    }

    public String redirectToCartPage(){
        return "/user/cart.xhtml?faces-redirect=true";
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
