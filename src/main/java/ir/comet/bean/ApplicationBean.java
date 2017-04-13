package ir.comet.bean;

import ir.comet.model.Customer;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean {

    String template="";

    public String loadTemplate(Customer customer){

        if(customer==null){

            template="/templates/CommonTemplate.xhtml";

        }else {

            template="/templates/UserTemplate.xhtml";

        }

        return template;
    }

}
