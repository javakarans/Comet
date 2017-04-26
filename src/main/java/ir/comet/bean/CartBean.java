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

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private List<UserProductCart> userProductCartList;

    @PostConstruct
    public void init(){
        userProductCartList = userSessionBean.getUserProductCartList();
    }

    public long calTotalPrice(){
        Iterator<UserProductCart> iterator = userProductCartList.iterator();
        long totalPrice=0;
        while (iterator.hasNext()){
            totalPrice=totalPrice+iterator.next().getProductCart().getTotalPriceAfterDiscountAndTax();
        }
        return totalPrice;
    }

    public void removeItem(UserProductCart userProductCart){
        userSessionBean.getUserProductCartList().remove(userProductCart);
    }

    public String redirectToUserPage(){
        return "/user/user.xhtml?faces-redirect=true";
    }

    public List<UserProductCart> getUserProductCartList() {
        return userProductCartList;
    }

    public void setUserProductCartList(List<UserProductCart> userProductCartList) {
        this.userProductCartList = userProductCartList;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
