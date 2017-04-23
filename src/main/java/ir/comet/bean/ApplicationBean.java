package ir.comet.bean;

import ir.comet.controller.MenuController;
import ir.comet.controller.ProductController;
import ir.comet.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean {

    String template="";
    private MenuController menuController;

    @PostConstruct
    public void init(){
        menuController=new MenuController();
    }

    public String loadTemplate(Customer customer){
        if(customer==null){
            template="/templates/CommonTemplate.xhtml";
        }else {
            template="/templates/UserTemplate.xhtml";
        }
        return template;
    }


    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

}
