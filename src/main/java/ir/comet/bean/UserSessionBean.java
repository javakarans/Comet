package ir.comet.bean;

import ir.comet.model.BranchDetails;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@SessionScoped
public class UserSessionBean {

    private Customer customer;
    private Product selectedProduct;
    private BranchDetailsWrapper branchDetailsWrapper;
    private List<UserProductCart> userProductCartList;

    @PostConstruct
    public void init(){
        userProductCartList=new ArrayList<UserProductCart>();
    }

//    public void loadCustomer(){
//        customer=new Customer();
//        this.customer= (Customer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
//    }

    public void invalidUserSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public BranchDetailsWrapper getBranchDetailsWrapper() {
        return branchDetailsWrapper;
    }

    public void setBranchDetailsWrapper(BranchDetailsWrapper branchDetailsWrapper) {
        this.branchDetailsWrapper = branchDetailsWrapper;
    }

    public List<UserProductCart> getUserProductCartList() {
        return userProductCartList;
    }

    public void setUserProductCartList(List<UserProductCart> userProductCartList) {
        this.userProductCartList = userProductCartList;
    }
}
