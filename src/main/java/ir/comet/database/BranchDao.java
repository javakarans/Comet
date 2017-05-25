package ir.comet.database;

import ir.comet.model.Branch;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface BranchDao {

    public boolean createBranch(Branch branch);
    public Branch getBranch(long branchId);
    public List<Branch> getAllBranches();
    public List<Branch> getBranchesByCategoryId(long id);
    public boolean updateBranch(Branch branch);
    public boolean deleteBranch(Branch branch);
}
