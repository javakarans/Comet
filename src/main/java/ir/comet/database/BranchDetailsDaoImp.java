package ir.comet.database;


import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BranchDetailsDaoImp implements BranchDetailsDao {
    public int createBranchDetails(BranchDetails branchDetails) {
        SqlHandler.create(branchDetails);
        return 0;
    }

    public BranchDetails getBranchDetails(long branchDetailsId) {
        return null;
    }

    public List<BranchDetails> getAlBranchDetails() {
        BranchDetails branchDetails = new BranchDetails();
        return SqlHandler.getAllObjects(branchDetails);

    }

    public List<Brand> getBrandsByBranchId(long id) {
        BrandDaoImp brandDaoImp = new BrandDaoImp();
        List<BranchDetails> branchDetailsList = SqlHandler.getObjectsBySpecialColumn(new BranchDetails(), "brandId", id);
        List<Brand> brands = new ArrayList<Brand>(branchDetailsList.size());
        for (BranchDetails branchDetails : branchDetailsList) {
            Brand brand = brandDaoImp.getBrand(branchDetails.getBrandId());
            brands.add(brand);
        }
        return brands;
    }

    public int updateBranchDetails(BranchDetails branchDetails) {
        SqlHandler.update(branchDetails);
        return 0;
    }

    public int deleteBranchDetails(BranchDetails branchDetails) {
        SqlHandler.delete(branchDetails);
        return 0;
    }
}
