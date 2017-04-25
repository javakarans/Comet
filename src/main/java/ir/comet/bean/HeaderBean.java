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

    private Customer customer;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init(){
        setCustomer(new Customer());
        loadUserSession();
    }

    public void loadUserSession() {
        Customer customer = (Customer) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("customer");
        this.setCustomer(customer);
    }

    public void userAccountBtn(){

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("customer",customer);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../user/userAccount.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(){

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../comet.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String redirectToProductPage(long branchId,long brandId){
        BranchDetailsDaoImp branchDetailsDaoImp=new BranchDetailsDaoImp();
        BranchDetailsWrapper branchDetailsWrapper=new BranchDetailsWrapper
                (branchDetailsDaoImp.getBranchDetails(branchId,brandId).get(0));
        sessionBean.setBranchDetailsWrapper(branchDetailsWrapper);
        return "/user/Product.xhtml?faces-redirect=true";
    }

    public String redirectToCartPage(){
        return "/user/cart.xhtml?faces-redirect=true";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
