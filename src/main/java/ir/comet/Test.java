package ir.comet;

import ir.comet.Utilities.TrackNumber;
import ir.comet.database.BranchDao;
import ir.comet.database.BranchDaoImp;
import ir.comet.database.CustomerDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.Customer;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mohammad on 5/20/2017.
 */
public class Test {

    public static void main(String[] args) {
//        Customer customer=new Customer();
//        customer.setEmail("good");
//        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
//        customerDaoImp.createCustomer(customer);

        BranchDaoImp branchDaoImp = new BranchDaoImp();
        List<Branch> branches = branchDaoImp.getBranchesByCategoryId(4);
        for (Branch branch: branches
             ) {
            System.out.println(branch.getBranchName());

        }
    }
}
