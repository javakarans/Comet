package ir.comet.bean;

import ir.comet.database.PaymentTransaction;
import ir.comet.model.*;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohammad on 4/27/2017.
 */
@ManagedBean
@ViewScoped
public class ReviewBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private List<UserProductCart> userProductCartList;
    private Map<String, String> requestParameterMap;

    @PostConstruct
    public void init(){
        userProductCartList = userSessionBean.getUserProductCartList();
        requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    }

    public long totalDiscountPrice(){
        Iterator<UserProductCart> iterator = userProductCartList.iterator();
        long totalDiscount=0;
        while (iterator.hasNext()){
            totalDiscount = totalDiscount+iterator.next().getProduct().getDiscount();
        }
        return totalDiscount;
    }

    public long totalPriceWithNoDiscount(){
        Iterator<UserProductCart> iterator = userProductCartList.iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            totalPrice=totalPrice+iterator.next().getProductCart().getTotalPrice();
        }
        return totalPrice;
    }

    public long totalPriceByDiscount(){
        Iterator<UserProductCart> iterator = userProductCartList.iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            totalPrice = totalPrice+iterator.next().getProductCart().getTotalPriceAfterDiscountAndTax();
        }
        return totalPrice;
    }

    public String ConfirmOrderAndPayment(){
        if(true){
            loadPaymentDetail("ByCash");
        }
        return "";
    }

    public void loadPaymentDetail(String paymentType){
        PaymentDetail paymentDetail=new PaymentDetail();
        paymentDetail.setCustomerId(userSessionBean.getCustomer().getCustomerId());
        paymentDetail.setOrderDetail(new OrderDetail());
        paymentDetail.setUserProductCartList(userProductCartList);
        Receipt receipt=new Receipt();
        receipt.setTotalPrice(totalPriceWithNoDiscount());
        receipt.setTotalPriceAfterDiscountAndTax(totalPriceByDiscount());
        receipt.setPaymentType(paymentType);
        receipt.setDeliveryDate("");
        receipt.setIssueDate("");
        receipt.setTrackingNumber(1);
        paymentDetail.setReceipt(receipt);
        PaymentTransaction paymentTransaction=new PaymentTransaction(paymentDetail);
        paymentTransaction.confirmPayment();
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public List<UserProductCart> getUserProductCartList() {
        return userProductCartList;
    }

    public void setUserProductCartList(List<UserProductCart> userProductCartList) {
        this.userProductCartList = userProductCartList;
    }
}
