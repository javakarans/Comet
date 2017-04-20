package ir.comet.bean;

import ir.comet.database.BranchDaoImp;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;
import ir.comet.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean(name = "dtAddBrandAndCategory")
@ViewScoped
public class AddBrandAndCategory {
    private BrandDaoImp brandDaoImp = new BrandDaoImp();
    private CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
    private Brand brand = new Brand();
    private Category category = new Category();
    private Branch branch = new Branch();
    private BranchDaoImp branchDaoImp = new BranchDaoImp();
    private BranchDetails branchDetails = new BranchDetails();
    private BranchDetailsDaoImp branchDetailsDaoImp = new BranchDetailsDaoImp();
    private List<Category> categoryList ;
    private List<Brand> brandList;
    private List<Branch> branchList;
    private Category selectedCategory;
    private Branch selectedBranch;
    private Brand selectedBrand;


    @PostConstruct
    public void init() {
        categoryList = categoryDaoImp.getAllCategories();
        branchList = branchDaoImp.getAllBranches();
        brandList = brandDaoImp.getAllBrands();
    }


    public void addBrand()
    {
        brandDaoImp.createBrand(brand);
        brandList.add(brand);
        brand = new Brand();
    }

    public void addCategory()
    {
        categoryDaoImp.createCategory(category);
        categoryList.add(category);
        category = new Category();
    }

    public void addBranch()
    {
        branch.setCategoryId(selectedCategory.getCategoryId());
        branchDaoImp.createBranch(branch);
        branchList.add(branch);
        branch = new Branch();
    }

    public void addBranchDetails()
    {
        branchDetails.setBrandId(selectedBrand.getBrandId());
        branchDetails.setBranchId(selectedBranch.getBranchId());
        branchDetailsDaoImp.createBranchDetails(branchDetails);
        branchDetails = new BranchDetails();
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public BranchDetails getBranchDetails() {
        return branchDetails;
    }

    public void setBranchDetails(BranchDetails branchDetails) {
        this.branchDetails = branchDetails;
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

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}
