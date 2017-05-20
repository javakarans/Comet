package ir.comet.bean;

import ir.comet.Utilities.SolarCalendar;
import ir.comet.Utilities.TrackNumber;
import ir.comet.database.CustomerDaoImp;
import ir.comet.database.PaymentTransaction;
import ir.comet.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Mohammad on 4/27/2017.
 */
@ManagedBean
@ViewScoped
public class ReviewBean{

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private Customer customer;
    private SolarCalendar solarCalendar;
    private String payment;

    @PostConstruct
    public void init(){
        checkAuthority();
        solarCalendar=new SolarCalendar();
        loadCustomer();
        payment=getPaymentType();
    }

    private void checkAuthority(){
        if(userSessionBean.getCurrentURL().equals("/user/confirmationPage.xhtml")){
            try {
                userSessionBean.reloadProductOrderDetailList();
                FacesContext.getCurrentInstance().getExternalContext().redirect("/user/userAccount.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public long totalDiscountPrice(){
        Iterator<ProductOrderDetail> iterator = userSessionBean.getProductOrderDetailList().iterator();
        long totalDiscount=0;
        while (iterator.hasNext()){
            totalDiscount = totalDiscount+iterator.next().getProduct().getDiscount();
        }
        return totalDiscount;
    }

    public long calPriceByDiscount(ProductOrderDetail productOrderDetail){
        long price = productOrderDetail.getProduct().getPrice();
        long discount = productOrderDetail.getProduct().getDiscount();
        return (price-discount);
    }

    public long totalPriceWithNoDiscount(){
        Iterator<ProductOrderDetail> iterator = userSessionBean.getProductOrderDetailList().iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            ProductOrderDetail next = iterator.next();
            next.setTotalPrice(next.getProduct().getPrice()*next.getQuantity());
            totalPrice = totalPrice + next.getTotalPrice();
        }
        return totalPrice;
    }

    public long totalPriceByDiscount(){
        Iterator<ProductOrderDetail> iterator = userSessionBean.getProductOrderDetailList().iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            totalPrice = totalPrice + iterator.next().getTotalPriceAfterDiscountAndTax();
        }
        return totalPrice;
    }

    public String getPaymentType(){
        String paymentType = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("payment");
        return paymentType;
    }

    public void loadCustomer(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customer=customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
    }

    public String ConfirmOrderAndPayment(){
        switch (payment){
            case PaymentType.BY_CASH:
                boolean done = payByCash();
                if (done){
                    return "/user/confirmationPage.xhtml?faces-redirect=true";
                }
                break;
            case PaymentType.BY_CREDIT_CARD:
                //Add Later
                break;
        }
        return "";
    }

    private boolean payByCash(){
        TrackNumber trackNumber=new TrackNumber();
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setCustomer(customer);
        orderDetail.setTotalPrice(totalPriceWithNoDiscount());
        orderDetail.setTotalPriceAfterDiscountAndTax(totalPriceByDiscount());
        orderDetail.setPaymentType(PaymentType.BY_CASH);
        orderDetail.setIssueDate(solarCalendar.getCurrentShamsidate());
        orderDetail.setTrackingNumber(trackNumber.generate(customer.getCustomerId()));
        orderDetail.setStatus(Status.ON_PENDING);
        PaymentTransaction transaction=new PaymentTransaction(userSessionBean.getProductOrderDetailList(),orderDetail);
        return transaction.confirmPayment();
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
}
