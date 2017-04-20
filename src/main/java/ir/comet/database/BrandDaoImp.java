package ir.comet.database;

import ir.comet.model.Brand;

import java.util.List;


public class BrandDaoImp implements BrandDao {

    private SqlHandler sqlHandler = new SqlHandler();

    public void createBrand(Brand brand) {
         sqlHandler.create(brand);
    }

    public Brand getBrand(long brandId) {
        return null;
    }

    public List<Brand> getAllBrands() {
        Brand brand = new Brand();
        return SqlHandler.getAllObjects(brand);
    }

    public void updateBrand(Brand brand) {
        SqlHandler.update(brand);
    }

    public void deleteBrand(Brand brand) {
        SqlHandler.delete(brand);
    }
}
