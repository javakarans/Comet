package ir.comet.bean;

import ir.comet.model.BranchDetails;
import ir.comet.model.Customer;
import ir.comet.model.Product;
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
    private List<UserProductCart> userProductCartList;
    private BranchDetails selectedBranchDetails;

    @PostConstruct
    public void init(){
        loadCustomer();
        userProductCartList=new ArrayList<UserProductCart>();
    }

    public void loadCustomer(){
        customer=new Customer();
        this.customer= (Customer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
    }

//    public void loadUserCartList(){
//        userCartList=new ArrayList<Product>();
//        this.userCartList= (List<Product>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userCartList");
//    }

    public String addProductToCart(Product product){
        userProductCartList.add(new UserProductCart(product));
        return "cart.xhtml?faces-redirect=true";
    }

    public long loadBranchDetailId(long branchId,long brandId){
//        return new BranchDetailsWrapper(branchId, brandId).getBranchDetailsWrapperId();
        return 1;
    }

    public String redirectToProductPage(long branchId,long brandId){

        return "user/Product.xhtml?faces-redirect=true&branchId="+branchId+"&brandId="+brandId;
    }

    public BranchDetails getSelectedBranchDetails() {
        return selectedBranchDetails;
    }

    public void setSelectedBranchDetails(BranchDetails selectedBranchDetails) {
        this.selectedBranchDetails = selectedBranchDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<UserProductCart> getUserProductCartList() {
        return userProductCartList;
    }

    public void setUserProductCartList(List<UserProductCart> userProductCartList) {
        this.userProductCartList = userProductCartList;
    }
}
