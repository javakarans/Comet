package ir.comet.bean;

import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Brand;
import ir.comet.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by amir on 5/23/2017.
 */
@ManagedBean
@ViewScoped
public class CategoryBean {
    private Category category;
    private CategoryDaoImp categoryDaoImp;
    private List<Category> categoryList;
    private Category selectedCategory;
    private FacesMessage msg;

    @PostConstruct
    public void init()
    {
        categoryDaoImp = new CategoryDaoImp();
        categoryList = categoryDaoImp.getAllCategories();
        category = new Category();
    }

    public void addCategory()
    {
        boolean result = categoryDaoImp.createCategory(category);
        if (result)
        {
            categoryList = categoryDaoImp.getAllCategories();
            category = new Category();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ذخیره شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeCategory(Category category)
    {
        boolean result = categoryDaoImp.deleteCategory(category);
        if (result)
        {
            categoryList = categoryDaoImp.getAllCategories();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "حذف شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void editCategory()
    {
        boolean result = categoryDaoImp.updateCategory(selectedCategory);

        if (result)
        {
            categoryList = categoryDaoImp.getAllCategories();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "به روز رسانی شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
