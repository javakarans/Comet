package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 3/9/2017.
 */
public class SqlHandler {

    private static Session session;

    static {
        session = HibernateSession.getInstance().getSession();
    }
    public static <T> void create(T object){
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();

    }

    public static <T> void update(T object){
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }

    public static <T> void delete(T object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    public static <T> List getAllObjects(T object)
    {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        session.getTransaction().commit();
        return criteria.list();
    }

    public static <T> List getObjectsBySpecialColumn(T object,String column,long id){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        criteria.add(Restrictions.eq(column,id));
        session.getTransaction().commit();
        return criteria.list();
    }

}
