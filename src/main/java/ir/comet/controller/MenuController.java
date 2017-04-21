package ir.comet.controller;

import ir.comet.database.BranchDaoImp;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.CategoryDaoImp;
import ir.comet.model.Branch;
import ir.comet.model.Brand;
import ir.comet.model.Category;

import java.util.List;

/**
 * Created by Mohammad on 4/20/2017.
 */
public class MenuController {

    private CategoryDaoImp categoryDaoImp;
    private BranchDaoImp branchDaoImp;
    private BranchDetailsDaoImp branchDetailsDaoImp;

    public MenuController(){
        categoryDaoImp=new CategoryDaoImp();
        branchDaoImp=new BranchDaoImp();
        branchDetailsDaoImp=new BranchDetailsDaoImp();
    }

    public List<Category> getAllCategoryList(){
        List<Category> allCategories = categoryDaoImp.getAllCategories();
        return allCategories;
    }

    public List<Branch> getBranchesByCategoryId(long categoryId){
        List<Branch> branchesByCategoryId = branchDaoImp.getBranchesByCategoryId(categoryId);
        return branchesByCategoryId;
    }

    public List<Brand> getBrandsByBranchId(long branchId){
        List<Brand> brandsByBranchId = branchDetailsDaoImp.getBrandsByBranchId(branchId);
        return brandsByBranchId;
    }

}
