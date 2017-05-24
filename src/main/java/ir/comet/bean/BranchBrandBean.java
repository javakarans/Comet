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
    private Branch selectedBranch;
    private Brand selectedBrand;

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

    public void addBranchBrand()
    {
        branchBrand.setBranch(selectedBranch);
        branchBrand.setBrand(selectedBrand);
        boolean result = branchBrandDaoImp.createBranchBrand(branchBrand);
        if (result)
        {
            branchBrandList = branchBrandDaoImp.getAlBranchBrand();
        }
        else
        {

        }
    }

    public BranchBrand getBranchBrand() {
        return branchBrand;
    }

    public void setBranchBrand(BranchBrand branchBrand) {
        this.branchBrand = branchBrand;
    }

    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public List<BranchBrand> getBranchBrandList() {
        return branchBrandList;
    }

    public void setBranchBrandList(List<BranchBrand> branchBrandList) {
        this.branchBrandList = branchBrandList;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
