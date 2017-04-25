package ir.comet.bean;

import ir.comet.model.Brand;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/25/2017.
 */
@ManagedBean
@SessionScoped
public class SessionBean {

    private Product selectedProduct;
    private BranchDetailsWrapper branchDetailsWrapper;
    private List<UserProductCart> userProductCartList;

    @PostConstruct
    public void init(){
        userProductCartList=new ArrayList<UserProductCart>();
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
