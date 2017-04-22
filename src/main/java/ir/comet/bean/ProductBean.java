package ir.comet.bean;

import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@ViewScoped
public class ProductBean {

    private List<Product> productList;
    private BranchDetailsWrapper branchDetailsWrapper;

    @PostConstruct
    public void init() {

        loadProductList();
    }

    public void loadProductList() {

        this.productList = (List<Product>) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("productList");
        this.setBranchDetailsWrapper((BranchDetailsWrapper) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("branchDetailsWrapper"));

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BranchDetailsWrapper getBranchDetailsWrapper() {
        return branchDetailsWrapper;
    }

    public void setBranchDetailsWrapper(BranchDetailsWrapper branchDetailsWrapper) {
        this.branchDetailsWrapper = branchDetailsWrapper;
    }
}
