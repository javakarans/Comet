package ir.comet.bean;

import ir.comet.database.CategoryDaoImp;
import ir.comet.model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 4/13/2017.
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean {

    private List<Category> categories;

    @PostConstruct
    public void init(){
        categories=new ArrayList<>();
        autoCreateMenu();
    }

    public void autoCreateMenu(){
        CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
        categories = categoryDaoImp.getAllCategories();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
