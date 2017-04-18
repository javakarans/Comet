package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CategoryDaoImp implements CategoryDao {

    private SessionFactory sessionFactory;

    public CategoryDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createCategory(Category category) {
        SqlHandler.create(category);
    }

    public Category getCategory(long categoryId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Category.class);
        criteria.add(Restrictions.eq("categoryId",categoryId));
        session.getTransaction().commit();
        session.close();
        List<Category> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Category> getAllCategories(long categoryId) {
        return null;
    }

    public void updateCategory(Category category) {
        SqlHandler.update(category);
    }

    public void deleteCategory(Category category) {
        SqlHandler.delete(category);
    }
}
