package ir.comet.bean;


import ir.comet.database.BranchBrandDaoImp;
import ir.comet.database.BranchDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.BranchBrand;
import ir.comet.model.Brand;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class BranchBrandBean {
    private BranchBrand branchBrand;
    private List<BranchBrand> branchBrandList;
    private BranchBrandDaoImp branchBrandDaoImp;
    private List<Branch> branchList;
    private BranchDaoImp branchDaoImp;
    private List<Brand> brandList;
    private BrandDaoImp brandDaoImp;

    @PostConstruct
    public void init()
    {
        branchBrand = new BranchBrand();
        branchBrandDaoImp = new BranchBrandDaoImp();
        branchBrandList = branchBrandDaoImp.getAlBranchBrand();
        branchDaoImp = new BranchDaoImp();
        brandDaoImp = new BrandDaoImp();
        branchList = branchDaoImp.getAllBranches();
        brandList = brandDaoImp.getAllBrands();
    }

    public BranchBrand getBranchBrand() {
        return branchBrand;
    }

    public void setBranchBrand(BranchBrand branchBrand) {
        this.branchBrand = branchBrand;
    }
}
