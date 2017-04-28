package ir.comet.database;


import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BranchDetailsDaoImp implements BranchDetailsDao {

    private SQLService SQLService;

    public BranchDetailsDaoImp(){
        SQLService =new SQLService();
    }

    public int createBranchDetails(BranchDetails branchDetails) {
        SQLService.create(branchDetails);
        return 0;
    }

    public BranchDetails getBranchDetails(long branchDetailsId) {
        return null;
    }

    public List<BranchDetails> getAlBranchDetails() {
        BranchDetails branchDetails = new BranchDetails();
        return SQLService.getAllObjects(branchDetails);

    }

    public List<Brand> getBrandsByBranchId(long id) {
        BrandDaoImp brandDaoImp = new BrandDaoImp();
        List<BranchDetails> branchDetailsList = SQLService.getObjectsBySpecialColumn(new BranchDetails(), "brandId", id);
        List<Brand> brands = new ArrayList<Brand>(branchDetailsList.size());
        for (BranchDetails branchDetails : branchDetailsList) {
            Brand brand = brandDaoImp.getBrand(branchDetails.getBrandId());
            brands.add(brand);
        }
        return brands;
    }

    public List<BranchDetails> getBranchDetails(long branchId,long brandId){
        return SQLService.getObjectsBySpecialColumn(new BranchDetails(), "branchId", branchId, "brandId", brandId);
    }

    public int updateBranchDetails(BranchDetails branchDetails) {
        SQLService.update(branchDetails);
        return 0;
    }

    public int deleteBranchDetails(BranchDetails branchDetails) {
        SQLService.delete(branchDetails);
        return 0;
    }

}
