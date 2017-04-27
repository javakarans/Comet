package ir.comet.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 3/9/2017.
 */
public class SqlHandler {

    public <T> void create(T object){
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public <T> void update(T object){
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public <T> void delete(T object){
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public <T> List getAllObjects(T object)
    {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(object.getClass());
        session.getTransaction().commit();
        List<T> list=criteria.list();
        session.flush();
        session.close();
        return list;

    }

    public <T> List getObjectsBySpecialColumn(T object,String column,Object value){
        Session session = HibernateSession.getSession();
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
        Session session = HibernateSession.getSession();
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
