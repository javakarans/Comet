package ir.comet.database;

import ir.comet.model.Brand;

import java.util.List;

public interface BrandDao {
    public void createBrand(Brand brand);
    public Brand getBrand(long brandId);
    public List<Brand> getAllBrands();
    public void updateBrand(Brand brand);
    public void deleteBrand(Brand brand);
}
