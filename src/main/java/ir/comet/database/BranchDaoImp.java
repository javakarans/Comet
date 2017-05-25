package ir.comet.database;

import ir.comet.model.Branch;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class BranchDaoImp implements BranchDao{

    private SQLService SQLService;

    public BranchDaoImp(){
        SQLService = new SQLService();
    }

    public boolean createBranch(Branch branch) {
        return SQLService.create(branch);
    }

    public Branch getBranch(long branchId) {
        return (Branch) SQLService.getObjectsBySpecialColumn(new Branch(),"branchId",branchId).get(0);
    }

    public List<Branch> getAllBranches() {
        return SQLService.getAllObjects(new Branch());
    }

    public List<Branch> getBranchesByCategoryId(long id) {
        return SQLService.getObjectsBySpecialColumn(new Branch(),"categoryId",id);
    }

    public boolean updateBranch(Branch branch) {
        return SQLService.update(branch);
    }

    public boolean deleteBranch(Branch branch) {
        return SQLService.delete(branch);
    }
}
