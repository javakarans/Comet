package ir.comet.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@ViewScoped
public class ShippingBean {

    private String paymentType;

    public String redirectToReviewPage(){
        return "/user/review.xhtml?faces-redirect=true&paymentType="+paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
