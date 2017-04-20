package ir.comet.database;


import ir.comet.model.BranchDetails;
import ir.comet.model.Brand;

import java.util.List;

public interface BranchDetailsDao {
    public int createBranchDetails(BranchDetails branchDetails);
    public BranchDetails getBranchDetails(long branchDetailsId);
    public List<BranchDetails> getAlBranchDetails();
    public List<Brand> getBrandsByBranchId(long id);
    public int updateBranchDetails(BranchDetails branchDetails);
    public int deleteBranchDetails(BranchDetails branchDetails);
}
