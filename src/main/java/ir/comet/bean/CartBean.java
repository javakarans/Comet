package ir.comet.bean;

import ir.comet.database.ProductDaoImp;
import ir.comet.model.Product;
import ir.comet.model.ProductOrderDetail;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@ViewScoped
public class CartBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;


    @PostConstruct
    public void init(){
    }

    public boolean checkProductCartListIsEmpty(){
        boolean empty = userSessionBean.getProductOrderDetailList().isEmpty();
        if(empty){
            return true;
        }
        return false;
    }

    public long calPriceByDiscount(ProductOrderDetail productOrderDetail){
        long price = productOrderDetail.getProduct().getPrice();
        long discount = productOrderDetail.getProduct().getDiscount();
        return (price-discount);
    }

    public long calTotalPriceAfterDiscountAndTax(ProductOrderDetail productOrderDetail){
        long price = calPriceByDiscount(productOrderDetail);
        int quantity=productOrderDetail.getQuantity();
        productOrderDetail.setTotalPriceAfterDiscountAndTax(price*quantity);
        return (productOrderDetail.getTotalPriceAfterDiscountAndTax());
    }

    public long calTotalPrice(){
        Iterator<ProductOrderDetail> iterator = userSessionBean.getProductOrderDetailList().iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            ProductOrderDetail next = iterator.next();
            totalPrice=totalPrice+next.getTotalPriceAfterDiscountAndTax();
        }
        return totalPrice;
    }

    public String redirectToShippingPage(){
        userSessionBean.setCurrentURL("/user/shipping.xhtml");
        return userSessionBean.getCurrentURL().concat("?faces-redirect=true");
    }

    public void removeProduct(ProductOrderDetail productOrderDetail){
        userSessionBean.getProductOrderDetailList().remove(productOrderDetail);
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

}
