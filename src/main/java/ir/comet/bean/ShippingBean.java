package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;
import ir.comet.model.PaymentType;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@ViewScoped
public class ShippingBean{

    private String paymentType;
    private String byCreditCard= PaymentType.BY_CREDIT_CARD;
    private String byCash=PaymentType.BY_CASH;
    private Customer customer;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
        checkAuthority();
        loadCustomer();
    }

    public void loadCustomer(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customer=customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
    }

    public boolean checkAuthority(){
        boolean listIsEmpty=userSessionBean.getProductOrderDetailList().isEmpty();
        if(listIsEmpty){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/user/cart.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public String redirectToReviewPage(){
        return "/user/review.xhtml?faces-redirect=true&payment="+paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public String getByCreditCard() {
        return byCreditCard;
    }

    public void setByCreditCard(String byCreditCard) {
        this.byCreditCard = byCreditCard;
    }

    public String getByCash() {
        return byCash;
    }

    public void setByCash(String byCash) {
        this.byCash = byCash;
    }

}
