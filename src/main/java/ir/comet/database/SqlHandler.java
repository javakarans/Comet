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

    private SessionFactory sessionFactory;
    private SqlHandler sqlHandler;

    private SqlHandler(){
        sessionFactory = HibernateSession.getInstance().getSession();
    }

    public  SqlHandler getInstance(){
//        if (sqlHandler == null) {
//            // Thread Safe. Might be costly operation in some case
//            synchronized (SqlHandler.class) {
//                if (sqlHandler == null) {
//                    sqlHandler = new SqlHandler();
//                }
//            }
//        }
        return new SqlHandler();
    }

    public synchronized  <T> void create(T object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public synchronized  <T> void update(T object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public synchronized  <T> void delete(T object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public <T> List getAllObjects(T object)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        session.getTransaction().commit();
        List<T> list=criteria.list();
        session.flush();
        session.close();
        return list;

    }

    public <T> List getObjectsBySpecialColumn(T object,String column,Object value){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        criteria.add(Restrictions.eq(column,value));
        session.getTransaction().commit();
        List<T> list=criteria.list();
        session.flush();
        session.close();
        return list;
    }

    public <T> List getObjectsBySpecialColumn(T object,String firstColumn,Object firstValue,String secondColumn,Object secondValue){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        criteria.add(Restrictions.eq(firstColumn,firstValue));
        criteria.add(Restrictions.eq(secondColumn,secondValue));
        session.getTransaction().commit();
        List<T> list=criteria.list();
        session.flush();
        session.close();
        return list;
    }

}
