package ir.comet.bean;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@ViewScoped
public class ProductBean implements Serializable{

    private List<Product> productList;
    private BranchDetailsWrapper branchDetailsWrapper;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {
        branchDetailsWrapper=sessionBean.getBranchDetailsWrapper();
        loadProductList();
    }

    public void loadProductList() {
        ProductDaoImp productDaoImp=new ProductDaoImp();
        this.productList=productDaoImp.getProductListBybranchDetailsId(branchDetailsWrapper.getBranchDetailsWrapperId());
    }

    public String redirectToProductContent(Product product){
        sessionBean.setSelectedProduct(product);
        return "productContent.xhtml?faces-redirect=true";
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
