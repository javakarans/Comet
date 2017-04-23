package ir.comet.wrapper;


import ir.comet.database.BranchDaoImp;
import ir.comet.database.BrandDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;
import ir.comet.model.Category;

public class BranchDetailsWrapper {
    private long branchDetailsWrapperId;
    private long categoryId;
    private String categoryName;
    private long branchId;
    private String branchName;
    private long brandId;
    private String brandName;

    public BranchDetailsWrapper(BranchDetails branchDetails) {
        this.branchDetailsWrapperId=branchDetails.getBranchDetailsId();
        this.brandId=branchDetails.getBrandId();
        this.branchId=branchDetails.getBranchId();
        fill();
    }

    public BranchDetailsWrapper(long branchId,long brandId){

    }

    public BranchDetails convertToOrginalClass(BranchDetailsWrapper branchDetailsWrapper)
    {
        BranchDetails branchDetails = new BranchDetails();
        branchDetails.setBranchDetailsId(branchDetailsWrapper.getBranchDetailsWrapperId());
        branchDetails.setBranchId(branchDetailsWrapper.getBranchId());
        branchDetails.setBrandId(branchDetailsWrapper.getBrandId());
        return branchDetails;
    }

    @Override
    public String toString() {
        return categoryName+"/"+branchName+"/"+brandName;
    }

    private void fill()
    {
        BranchDaoImp branchDaoImp = new BranchDaoImp();
        Branch branch = branchDaoImp.getBranch(this.branchId);
        this.branchName = branch.getBranchName();
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        Category category = categoryDaoImp.getCategory(branch.getCategoryId());
        this.categoryName = category.getName();
        BrandDaoImp brandDaoImp = new BrandDaoImp();
        Brand brand = brandDaoImp.getBrand(this.brandId);
        if (brand != null)
            this.brandName = brand.getName();
    }

    public long getBranchDetailsWrapperId() {
        return branchDetailsWrapperId;
    }

    public void setBranchDetailsWrapperId(long branchDetailsWrapperId) {
        this.branchDetailsWrapperId = branchDetailsWrapperId;
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
}
