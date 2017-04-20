package ir.comet.database;


import ir.comet.model.Order;
import ir.comet.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProductDaoImp implements ProductDao {
    private SessionFactory sessionFactory;
    public ProductDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createProduct(Product product) {
        SqlHandler.create(product);
    }

    public Product getProduct(long productId) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.eq("productId",productId));
        session.getTransaction().commit();
        List<Product> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);
        session.getTransaction().commit();
        return criteria.list();

    }

    public void updateProduct(Product product) {

        SqlHandler.update(product);
    }

    public void deleteProduct(Product product) {
        SqlHandler.delete(product);
    }
}
