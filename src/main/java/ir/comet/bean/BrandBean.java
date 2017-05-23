package ir.comet.bean;

import ir.comet.database.BrandDaoImp;
import ir.comet.model.Brand;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    @PostConstruct
    public void init()
    {
        brand = new Brand();
        brandDaoImp = new BrandDaoImp();
        brandList = brandDaoImp.getAllBrands();
    }

    public void addBrand()
    {
        boolean result = brandDaoImp.createBrand(brand);
        brandList = brandDaoImp.getAllBrands();
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
}
