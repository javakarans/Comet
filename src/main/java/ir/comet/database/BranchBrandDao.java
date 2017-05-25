package ir.comet.database;


import ir.comet.model.BranchBrand;
import ir.comet.model.Brand;

import java.util.List;

public interface BranchBrandDao {
    public boolean createBranchBrand(BranchBrand branchBrand);
    public BranchBrand getBranchBrand(long branchBrandId);
    public List<BranchBrand> getBranchBrand(long branchId, long brandId);
    public List<BranchBrand> getAlBranchBrand();
    public List<Brand> getBrandsByBranchId(long id);
    public int updateBranchBrand(BranchBrand branchBrand);
    public boolean deleteBranchBrand(BranchBrand branchBrand);
}
