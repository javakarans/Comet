package ir.comet.bean;

import ir.comet.model.Customer;
import ir.comet.model.Product;

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
    private List<Product> userCartList;

    @PostConstruct
    public void init(){
        loadCustomer();
        loadUserCartList();
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

    public void loadCustomer(){
        customer=new Customer();
        this.customer= (Customer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("customer");
    }

    public void loadUserCartList(){
        userCartList=new ArrayList<Product>();
        this.userCartList= (List<Product>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userCartList");
    }
}
