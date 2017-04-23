package ir.comet.bean;

import ir.comet.controller.ProductController;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/16/2017.
 */
@ManagedBean
@SessionScoped
public class UserSessionBean {

    private Customer customer;
    private List<Product> userCartList;
    private BranchDetails selectedBranchDetails;

    @PostConstruct
    public void init(){
        loadCustomer();
        loadUserCartList();
    }

    public void loadCustomer(){
        customer=new Customer();
        this.customer= (Customer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
    }

    public void loadUserCartList(){
        userCartList=new ArrayList<Product>();
        this.userCartList= (List<Product>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userCartList");
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

    public List<Product> getUserCartList() {
        return userCartList;
    }

    public void setUserCartList(List<Product> userCartList) {
        this.userCartList = userCartList;
    }
}
