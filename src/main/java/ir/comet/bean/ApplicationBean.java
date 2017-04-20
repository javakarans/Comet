package ir.comet.bean;

import ir.comet.database.BranchDaoImp;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.database.CategoryDaoImp;
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
    private List<Category> categoryList;
    private CategoryDaoImp categoryDaoImp;
    private BranchDaoImp branchDaoImp;
    private BranchDetailsDaoImp branchDetailsDaoImp;

    @PostConstruct
    public void init(){
        categoryDaoImp=new CategoryDaoImp();
        setCategoryList(categoryDaoImp.getAllCategories());
        branchDaoImp=new BranchDaoImp();
        branchDetailsDaoImp = new BranchDetailsDaoImp();

    }

    public String loadTemplate(Customer customer){

        if(customer==null){

            template="/templates/CommonTemplate.xhtml";

        }else {

            template="/templates/UserTemplate.xhtml";

        }

        return template;
    }

    public boolean addNewCategoryToCategoryList(Category category){
        return categoryList.add(category);
    }

    public List<Branch> getBranchesByCategory(long categoryId){
        return branchDaoImp.getBranchesByCategoryId(categoryId);
    }

    public List<Brand> getBrandByBranches(long branchId){
        return  branchDetailsDaoImp.getBrandsByBranchId(branchId);
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
