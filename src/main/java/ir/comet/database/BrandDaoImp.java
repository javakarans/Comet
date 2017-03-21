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
        return null;
    }

    public void updateBrand(Brand brand) {

    }

    public void deleteBrand(Brand brand) {

    }
}
