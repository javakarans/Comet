import ir.comet.database.BranchDaoImp;
import ir.comet.database.HibernateSession;
import ir.comet.model.Branch;
import ir.comet.model.Brand;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amir on 2/24/2017.
 */
public class Test {

    final static Logger logger=Logger.getLogger(Test.class);

    public static void main(String[] args) {

        Branch branch=new Branch();
        branch.setBrandId(1);
        branch.setBranchId(2);
        branch.setCategoryId(3);
        BranchDaoImp branchDaoImp=new BranchDaoImp();
        branchDaoImp.createBranch(branch);
    }

}
