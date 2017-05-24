package ir.comet.controller;

import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Customer;

import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Mohammad on 4/13/2017.
 */
public class LoginController {

    private String userName;
    private String password;

    public Customer customerLogin(){

        if(userName.equals("admin"))
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/orders.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        Customer customer= customerDaoImp.getCustomerByUserNameAndPass(this.userName,this.password);
        return customer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
