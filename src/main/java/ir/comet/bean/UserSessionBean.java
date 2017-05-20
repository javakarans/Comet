package ir.comet.bean;


import ir.comet.model.ProductOrderDetail;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@SessionScoped
public class UserSessionBean {

    private long userSessionId;
    private boolean userLogin;
    private HashMap<String,Long> URLParameter;
    private String currentURL;
    private List<ProductOrderDetail> productOrderDetailList;

    @PostConstruct
    public void init(){
        URLParameter=new HashMap<>();
        productOrderDetailList=new ArrayList<>();
    }

    public String loadTemplate(){
        if(userLogin){
            return "/templates/user/userTemplate.xhtml";
        }
        return "/templates/common/commonTemplate.xhtml";
    }

    public void reloadProductOrderDetailList(){
        productOrderDetailList.clear();
        URLParameter.clear();
        currentURL="";
    }

    public void invalidUserSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public long getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(long userSessionId) {
        this.userSessionId = userSessionId;
    }

    public boolean isUserLogin() {
        return userLogin;
    }

    public void setUserLogin(boolean userLogin) {
        this.userLogin = userLogin;
    }

    public HashMap<String, Long> getURLParameter() {
        return URLParameter;
    }

    public void setURLParameter(HashMap<String, Long> URLParameter) {
        this.URLParameter = URLParameter;
    }

    public List<ProductOrderDetail> getProductOrderDetailList() {
        return productOrderDetailList;
    }

    public void setProductOrderDetailList(List<ProductOrderDetail> productOrderDetailList) {
        this.productOrderDetailList = productOrderDetailList;
    }

    public String getCurrentURL() {
        return currentURL;
    }

    public void setCurrentURL(String currentURL) {
        this.currentURL = currentURL;
    }
}
