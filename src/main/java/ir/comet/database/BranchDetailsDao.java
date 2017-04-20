package ir.comet.database;


import ir.comet.model.BranchDetails;

import java.util.List;

public interface BranchDetailsDao {
    public int createBranchDetails(BranchDetails branchDetails);
    public BranchDetails getBranchDetails(long branchDetailsId);
    public List<BranchDetails> getAlBranchDetails();
    public int updateBranchDetails(BranchDetails branchDetails);
    public int deleteBranchDetails(BranchDetails branchDetails);
}
