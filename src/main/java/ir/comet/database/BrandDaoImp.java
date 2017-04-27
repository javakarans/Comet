package ir.comet.database;

import ir.comet.model.Brand;
import ir.comet.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class BrandDaoImp implements BrandDao {

    private SqlHandler sqlHandler;
    public BrandDaoImp()
    {
        sqlHandler=new SqlHandler();
    }

    public void createBrand(Brand brand) {
          sqlHandler.create(brand);
    }

    public Brand getBrand(long brandId) {
        return (Brand) sqlHandler.getObjectsBySpecialColumn(new Brand(),"brandId",brandId).get(0);
    }

    public List<Brand> getAllBrands() {
        Brand brand = new Brand();
        return sqlHandler.getAllObjects(brand);
    }

    public void updateBrand(Brand brand) {
        sqlHandler.update(brand);
    }

    public void deleteBrand(Brand brand) {
        sqlHandler.delete(brand);
    }
}
