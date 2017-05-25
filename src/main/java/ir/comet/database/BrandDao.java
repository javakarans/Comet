package ir.comet.database;

import ir.comet.model.Brand;

import java.util.List;

public interface BrandDao {
    public boolean createBrand(Brand brand);
    public Brand getBrand(long brandId);
    public List<Brand> getAllBrands();
    public boolean updateBrand(Brand brand);
    public boolean deleteBrand(Brand brand);
}
