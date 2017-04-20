package ir.comet.wrapper;


import ir.comet.database.BranchDaoImp;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;
import ir.comet.model.Category;

public class BranchDetailsWrapper {
    private long branchDetailsId;
    private long brandId;
    private String brandName;
    private long branchId;
    private String branchName;
    private long categoryId;
    private String categoryName;


    public BranchDetailsWrapper(BranchDetails branchDetails)
    {
        this.branchDetailsId = branchDetails.getBranchDetailsId();
        this.branchId = branchDetails.getBranchId();
        this.brandId = branchDetails.getBrandId();
        fill();
    }

    public BranchDetails convertToOrginalClass(BranchDetailsWrapper branchDetailsWrapper)
    {
        BranchDetails branchDetails = new BranchDetails();
        branchDetails.setBranchDetailsId(branchDetailsWrapper.getBranchDetailsId());
        branchDetails.setBranchId(branchDetailsWrapper.getBranchId());
        branchDetails.setBrandId(branchDetailsWrapper.getBrandId());
        return branchDetails;
    }

    @Override
    public String toString() {
        return categoryName+"/" + branchName+ "/" + brandName ;
    }

    private void fill()
    {
        BranchDaoImp branchDaoImp = new BranchDaoImp();
        Branch branch = branchDaoImp.getBranch(branchId);
        this.branchName = branch.getBranchName();
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        Category category = categoryDaoImp.getCategory(branch.getCategoryId());
        this.categoryId = branch.getCategoryId();
        this.categoryName = category.getName();
        BrandDaoImp brandDaoImp = new BrandDaoImp();
        Brand brand = brandDaoImp.getBrand(this.brandId);
        this.brandName = brand.getName();

    }

    public long getBranchDetailsId() {
        return branchDetailsId;
    }

    public void setBranchDetailsId(long branchDetailsId) {
        this.branchDetailsId = branchDetailsId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
