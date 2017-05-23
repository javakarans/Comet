package ir.comet.bean;
import ir.comet.database.BranchBrandDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchBrand;
import ir.comet.model.Product;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohammad on 3/31/2017.
 */
@ManagedBean
@ViewScoped
public class ProductBean implements Serializable{

    private List<Product> productList;
    private String categoryName;
    private String branchName;
    private String brandName;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    @PostConstruct
    public void init(){
        productList=new ArrayList<>();
        loadProductList();
    }

    public long getBranchBrandId(){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if(id!=null){
            return Long.parseLong(id);
        }
        return userSessionBean.getURLParameter().get("branchBrandId");
    }

    public void loadProductList(){
        BranchBrandDaoImp branchBrandDaoImp=new BranchBrandDaoImp();
        BranchBrand branchBrand = branchBrandDaoImp.getBranchBrand(getBranchBrandId());
        categoryName=branchBrand.getBranch().getCategory().getName();
        branchName=branchBrand.getBranch().getBranchName();
        brandName=branchBrand.getBrand().getName();
        productList=branchBrand.getProducts();
    }

    public long calPriceByDiscount(Product product){
        return (product.getPrice()-product.getDiscount());
    }

    public boolean productListIsEmpty(){
        return productList.isEmpty();
    }

    public String redirectToProductContent(long productId){
        userSessionBean.getURLParameter().put("productId",productId);
        userSessionBean.setCurrentURL("/user/productContent.xhtml?"+"productId="+productId);
        return "/user/productContent.xhtml?faces-redirect=true&"+"productId="+productId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

}
