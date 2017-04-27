import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.comet.database.*;
import ir.comet.model.*;
import ir.comet.wrapper.BranchDetailsWrapper;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by amir on 2/24/2017.
 */
public class Test {

    final static Logger logger=Logger.getLogger(Test.class);



    public static void main(String[] args) {

        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        for (int i =0 ; i<100000000;i++)
        {
            Category category = new Category();
            category.setName(String.valueOf(i));
            categoryDaoImp.createCategory(category);
            System.out.println(i);
        }

//        FilesLocations filesLocations = new FilesLocations();
//        filesLocations.setFileName("mobile");
//        filesLocations.getFilesList().add("1");
//        filesLocations.getFilesList().add("1zcx");
//        filesLocations.getFilesList().add("1zxcz");
//        filesLocations.getFilesList().add("1vczxvzxvzxcv");
//        filesLocations.getFilesList().add("1154");
//
//        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
//
//        Gson gson = builder.create();
//
//        System.out.println(gson.toJson(filesLocations));

        /* List<BranchDetailsWrapper> branchDetailsWrapperList;
         BranchDetailsDaoImp branchDetailsDaoImp;

        branchDetailsDaoImp = new BranchDetailsDaoImp();
        List<BranchDetails> branchDetailsList = branchDetailsDaoImp.getAlBranchDetails();
        branchDetailsWrapperList = new ArrayList<BranchDetailsWrapper>(branchDetailsList.size());
        for (BranchDetails branchDetails : branchDetailsList) {
            branchDetailsWrapperList.add(new BranchDetailsWrapper(branchDetails));
        }
       /* Branch branch=new Branch();
        //branch.setBrandId(1);
        branch.setBranchId(2);
        branch.setCategoryId(3);
        BranchDaoImp branchDaoImp=new BranchDaoImp();
        branchDaoImp.createBranch(branch);*/


    }

}
