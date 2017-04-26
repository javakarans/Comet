package ir.comet.bean;

import ir.comet.model.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Mohammad on 4/26/2017.
 */
@ManagedBean
@ViewScoped
public class UserPageBean {

    @PostConstruct
    public void init(){
        System.out.println("userpage");
    }

    public String checkUserStatus(Customer customer){
        System.out.println(customer);
        if(customer!=null){
            return "/user/shipping.xhtml?faces-redirect=true";
        }
        return null;
    }

    public String redirectToRegisterPage(){
        return "registerPage.xhtml?faces-redirect=true";
    }
}
