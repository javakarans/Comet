package ir.comet.bean;

import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@ViewScoped
public class ProductBean {

    private List<Product> productList;
    private BranchDetailsWrapper branchDetailsWrapper;
    private long branchDetailsId;
    private HashMap<String, Long> urlParams;

    @PostConstruct
    public void init() {
        urlParams = getParametersFromUrl();
        loadBranchDetailsWrapper();
        loadProductList();
    }

    public void loadProductList() {
        ProductDaoImp productDaoImp=new ProductDaoImp();
        this.productList=productDaoImp.getProductListBybranchDetailsId(branchDetailsWrapper.getBranchDetailsWrapperId());
    }

    public HashMap<String,Long> getParametersFromUrl(){
        long branchId = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("branchId"));
        long brandId = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("brandId"));
        HashMap<String,Long> hashMap=new HashMap<String, Long>();
        hashMap.put("branchId",branchId);
        hashMap.put("brandId",brandId);
        return hashMap;
    }

    public void loadBranchDetailsWrapper(){
        BranchDetailsDaoImp branchDetailsDaoImp=new BranchDetailsDaoImp();
        branchDetailsWrapper=new BranchDetailsWrapper(branchDetailsDaoImp
                .getBranchDetails(urlParams.get("branchId"),urlParams.get("brandId")).get(0));
    }

    public String redirectToProductContent(long productId){
        return "productContent.xhtml?faces-redirect=true&productId="+productId;
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

    public long getBranchDetailsId() {
        return branchDetailsId;
    }

    public void setBranchDetailsId(long branchDetailsId) {
        this.branchDetailsId = branchDetailsId;
    }

}
