package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.BranchBrand;
import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    private Customer customer;
    private String searchTextField;

    @PostConstruct
    public void init(){
        loadUserData();
    }

    public void doSearch(){
        System.out.println("search...");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/user/product.xhtml?searchBy="+searchTextField);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUserData(){
        if(userSessionBean.isUserLogin()){
            CustomerDaoImp customerDaoImp=new CustomerDaoImp();
            customer = customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
        }
    }

    public void logoutUser(){
        userSessionBean.invalidUserSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String redirectToCartPage(){
        userSessionBean.setCurrentURL("/user/cart.xhtml?faces-redirect=true");
        return userSessionBean.getCurrentURL();
    }

    public String redirectToProductPage(BranchBrand branchBrand){
        return "/user/product.xhtml?faces-redirect=true&id="+branchBrand.getBranchBrandId();
    }

    public String redirectToUserAccount(){
        return "/user/userAccount.xhtml?faces-redirect=true";
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


    public String getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(String searchTextField) {
        this.searchTextField = searchTextField;
    }
}
