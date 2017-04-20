package ir.comet.database;


import ir.comet.model.BranchDetails;

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

    public int updateBranchDetails(BranchDetails branchDetails) {
        SqlHandler.update(branchDetails);
        return 0;
    }

    public int deleteBranchDetails(BranchDetails branchDetails) {
        SqlHandler.delete(branchDetails);
        return 0;
    }
}
