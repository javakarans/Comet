package ir.comet.bean;


import ir.comet.database.BranchBrandDaoImp;
import ir.comet.database.BranchDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.BranchBrand;
import ir.comet.model.Brand;
import ir.comet.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private FacesMessage msg;
    @ManagedProperty(value = "#{applicationBean}")
    private ApplicationBean applicationBean;
    private BranchBrand selectedBranchBrand;

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
            branchBrand = new BranchBrand();
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

    public void removeBranchBrand(BranchBrand branchBrand)
    {
        boolean result = branchBrandDaoImp.deleteBranchBrand(branchBrand);
        if (result)
        {
            branchBrandList = branchBrandDaoImp.getAlBranchBrand();
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

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public BranchBrand getSelectedBranchBrand() {
        return selectedBranchBrand;
    }

    public void setSelectedBranchBrand(BranchBrand selectedBranchBrand) {
        this.selectedBranchBrand = selectedBranchBrand;
    }
}
