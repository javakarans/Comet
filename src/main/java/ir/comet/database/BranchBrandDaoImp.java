package ir.comet.database;


import ir.comet.model.BranchBrand;
import ir.comet.model.Brand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BranchBrandDaoImp implements BranchBrandDao {

    private SQLService SQLService;

    public BranchBrandDaoImp(){
        SQLService =new SQLService();
    }

    public boolean createBranchBrand(BranchBrand branchBrand) {
        return SQLService.create(branchBrand);
    }

    public BranchBrand getBranchBrand(long branchBrandId) {
        return (BranchBrand) SQLService.getObjectsBySpecialColumn(new BranchBrand(),"branchBrandId",branchBrandId).get(0);
    }

    public List<BranchBrand> getAlBranchBrand() {
        return SQLService.getAllObjects(new BranchBrand());

    }

    public List<Brand> getBrandsByBranchId(long id) {
        BrandDaoImp brandDaoImp = new BrandDaoImp();
        List<BranchBrand> branchBrandList = SQLService.getObjectsBySpecialColumn(new BranchBrand(), "branchId", id);
        List<Brand> brands = new ArrayList<Brand>();
        Iterator<BranchBrand> iterator = branchBrandList.iterator();
        while (iterator.hasNext()){
            BranchBrand next = iterator.next();
            Brand brand = brandDaoImp.getBrand(next.getBranch().getBranchId());
            brands.add(brand);
        }
        return brands;
    }

    public List<BranchBrand> getBranchBrand(long branchId, long brandId){
        return SQLService.getObjectsBySpecialColumn(new BranchBrand(), "branchId", branchId, "brandId", brandId);
    }

    public int updateBranchBrand(BranchBrand branchBrand) {
        SQLService.update(branchBrand);
        return 0;
    }

    public int deleteBranchBrand(BranchBrand branchBrand) {
        SQLService.delete(branchBrand);
        return 0;
    }

}
