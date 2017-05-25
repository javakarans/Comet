package ir.comet.bean;

import ir.comet.database.BranchDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private FacesMessage msg;
    @ManagedProperty(value = "#{applicationBean}")
    private ApplicationBean applicationBean;
    private Branch selectedBranch;

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
        if (result)
        {
            selectedCategory = categoryDaoImp.getCategory(branch.getCategory().getCategoryId());
            branchList = selectedCategory.getBranches();
            branch = new Branch();
            applicationBean.autoCreateMenu();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ذخیره شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeBranch(Branch branch)
    {
        boolean result = branchDaoImp.deleteBranch(branch);
        if (result)
        {
            selectedCategory = categoryDaoImp.getCategory(branch.getCategory().getCategoryId());
            branchList = selectedCategory.getBranches();
            applicationBean.autoCreateMenu();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "حذف شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void editBranch()
    {
        boolean result = branchDaoImp.updateBranch(selectedBranch);

        if (result)
        {
            selectedCategory = categoryDaoImp.getCategory(selectedBranch.getCategory().getCategoryId());
            branchList = selectedCategory.getBranches();
            applicationBean.autoCreateMenu();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "به روز رسانی شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }
}
