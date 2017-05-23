package ir.comet.bean;

import ir.comet.database.CategoryDaoImp;
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
public class CategoryBean {
    private Category category;
    private CategoryDaoImp categoryDaoImp;
    private List<Category> categoryList;


    @PostConstruct
    public void init()
    {
        categoryDaoImp = new CategoryDaoImp();
        category = new Category();
    }

    public void addCategory()
    {
        boolean result = categoryDaoImp.createCategory(category);

        if (result)
        {
            categoryList = categoryDaoImp.getAllCategories();
        }
        else
        {

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
}
