package ir.comet.database;

import ir.comet.model.Brand;
import ir.comet.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class BrandDaoImp implements BrandDao {

    private SessionFactory sessionFactory;

    public BrandDaoImp()
    {
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createBrand(Brand brand) {
          SqlHandler.create(brand);
    }

    public Brand getBrand(long brandId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Brand.class);
        criteria.add(Restrictions.eq("brandId",brandId));
        session.getTransaction().commit();
        List<Brand> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
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
