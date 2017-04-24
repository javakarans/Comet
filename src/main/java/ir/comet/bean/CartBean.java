package ir.comet.bean;

import ir.comet.model.Product;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@ViewScoped
public class CartBean {

    private List<Product> productCartList;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
    }

    public long calTotalPrice(){
        List<UserProductCart> userProductCartList = userSessionBean.getUserProductCartList();
        Iterator<UserProductCart> iterator = userProductCartList.iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            totalPrice=totalPrice+iterator.next().getProductCart().getTotalPriceAfterDiscountAndTax();
        }
        return totalPrice;
    }

    public List<Product> getProductCartList() {
        return productCartList;
    }

    public void setProductCartList(List<Product> productCartList) {
        this.productCartList = productCartList;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
