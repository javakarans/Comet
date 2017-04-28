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

    public void createBranch(Branch branch) {
        SQLService.create(branch);
    }

    public Branch getBranch(long branchId) {

        return (Branch) SQLService.getObjectsBySpecialColumn(new Branch(),"branchId",branchId).get(0);
    }

    public List<Branch> getAllBranches() {

        Branch branch = new Branch();
        return SQLService.getAllObjects(branch);
    }

    public List<Branch> getBranchesByCategoryId(long id) {
        return SQLService.getObjectsBySpecialColumn(new Branch(),"categoryId",id);
    }

    public void updateBranch(Branch branch) {
        SQLService.update(branch);
    }

    public void deleteBranch(Branch branch) {
        SQLService.delete(branch);
    }
}
