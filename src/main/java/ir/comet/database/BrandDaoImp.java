package ir.comet.database;

import ir.comet.model.Brand;

import java.util.List;


public class BrandDaoImp implements BrandDao {

    private SQLService SQLService;
    public BrandDaoImp()
    {
        SQLService =new SQLService();
    }

    public boolean createBrand(Brand brand) {
          return SQLService.create(brand);
    }

    public Brand getBrand(long brandId) {
        return (Brand) SQLService.getObjectsBySpecialColumn(new Brand(),"brandId",brandId).get(0);
    }

    public List<Brand> getAllBrands() {
        Brand brand = new Brand();
        return SQLService.getAllObjects(brand);
    }

    public boolean updateBrand(Brand brand) {
        return SQLService.update(brand);
    }

    public boolean deleteBrand(Brand brand) {
        return SQLService.delete(brand);
    }
}
