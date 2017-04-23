package ir.comet.database;

import ir.comet.model.Branch;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class BranchDaoImp implements BranchDao{

    private SqlHandler sqlHandler;

    public BranchDaoImp(){
        sqlHandler = SqlHandler.getInstance();
    }

    public void createBranch(Branch branch) {
        sqlHandler.create(branch);
    }

    public Branch getBranch(long branchId) {

        return (Branch) sqlHandler.getObjectsBySpecialColumn(new Branch(),"branchId",branchId).get(0);
    }

    public List<Branch> getAllBranches() {

        Branch branch = new Branch();
        return sqlHandler.getAllObjects(branch);
    }

    public List<Branch> getBranchesByCategoryId(long id) {
        return sqlHandler.getObjectsBySpecialColumn(new Branch(),"categoryId",id);
    }

    public void updateBranch(Branch branch) {
        sqlHandler.update(branch);
    }

    public void deleteBranch(Branch branch) {
        sqlHandler.delete(branch);
    }
}
