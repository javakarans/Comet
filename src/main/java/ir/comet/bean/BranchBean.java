package ir.comet.bean;

import ir.comet.database.BranchDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by amir on 5/23/2017.
 */
@ManagedBean
@ViewScoped
public class BranchBean {
    private Category selectedCategory;
    private CategoryDaoImp categoryDaoImp;
    private List<Category> categories;
    private List<Branch> branchList;
    private BranchDaoImp branchDaoImp;
    private Branch branch;

    @PostConstruct
    public void init()
    {
        categoryDaoImp = new CategoryDaoImp();
        categories = categoryDaoImp.getAllCategories();
        branchDaoImp = new BranchDaoImp();
        branchList = branchDaoImp.getAllBranches();
        branch = new Branch();
    }


    public void onChange() {
        if (selectedCategory!=null)
        {
            branchList = selectedCategory.getBranches();
            branch.setCategory(selectedCategory);
        }
    }

    public void addBranch()
    {
        branch.setCategory(selectedCategory);
        boolean result = branchDaoImp.createBranch(branch);
        branch = new Branch();
        if (result)
        {
            branchList = selectedCategory.getBranches();
        }
        else
        {

        }
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
