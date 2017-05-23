package ir.comet.bean;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;
import ir.comet.model.OrderDetail;
import ir.comet.model.Product;
import ir.comet.model.Status;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ViewScoped
public class UserAccountBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private Customer customer;
    private int rowIndex;

    @PostConstruct
    public void init(){
        loadUserData();
    }

    public void loadUserData(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customer=customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
    }

    public int totalNumberOfOrders(){
        return customer.getOrderDetails().size();
    }

    public int onPendingOrders(){
        int count=0;
        for (OrderDetail orderDetail:customer.getOrderDetails()){
            if(orderDetail.getStatus().equals(Status.ON_PENDING)){
                count++;
            }
        }
        return count;
    }

    public int totalNumberOfOrderDelivered(){
        int count=0;
        for (OrderDetail orderDetail:customer.getOrderDetails()){
            if(orderDetail.getStatus().equals(Status.DELIVERED)){
                count++;
            }
        }
        return count;
    }

    public int incRowIndex(){
        return rowIndex=rowIndex+1;
    }

    public long calPriceByDiscount(Product product){
        return (product.getPrice()-product.getDiscount());
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

}
