package ir.comet.bean;

import ir.comet.database.BrandDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Brand;
import ir.comet.model.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "dtAddBrandAndCategory")
@ViewScoped
public class AddBrandAndCategory {
    private BrandDaoImp brandDaoImp = new BrandDaoImp();
    private CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
    private Brand brand = new Brand();
    private Category category = new Category();


    public void addBrand()
    {
        brandDaoImp.createBrand(brand);
        brand = new Brand();
    }

    public void addCategory()
    {

    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
