package ir.comet.bean;

import ir.comet.database.BrandDaoImp;
import ir.comet.model.Brand;

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
public class BrandBean {
    private Brand brand;
    private BrandDaoImp brandDaoImp;
    private List<Brand> brandList;
    private Brand selectedBrand;
    private FacesMessage msg;

    @PostConstruct
    public void init()
    {
        brand = new Brand();
        brandDaoImp = new BrandDaoImp();
        brandList = brandDaoImp.getAllBrands();
        selectedBrand = new Brand();
    }

    public void addBrand()
    {
        boolean result = brandDaoImp.createBrand(brand);
        if (result)
        {
            brandList = brandDaoImp.getAllBrands();
            brand = new Brand();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ذخیره شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeBrand(Brand brand)
    {
        boolean result = brandDaoImp.deleteBrand(brand);
        if (result)
        {
            brandList = brandDaoImp.getAllBrands();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "حذف شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void updateBrand()
    {
        boolean result = brandDaoImp.updateBrand(selectedBrand);
        if (result)
        {
            brandList = brandDaoImp.getAllBrands();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "به روز رسانی شد", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
        else
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ناموفق", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void f(Brand brand)
    {
        this.selectedBrand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
    }
}
