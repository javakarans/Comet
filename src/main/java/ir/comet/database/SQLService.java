package ir.comet.database;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 3/9/2017.
 */
public class SQLService {

    public <T> boolean create(T object){
        try{
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(object);
            HibernateUtil.commitTransaction();
        }catch (HibernateException e){
            HibernateUtil.rollbackTransaction();
            return false;
        }
        return true;
    }

    public <T> boolean update(T object){
        try{
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().update(object);
            HibernateUtil.commitTransaction();
        }catch (HibernateException e){
            HibernateUtil.rollbackTransaction();
            return false;
        }
        return true;
    }

    public <T> boolean delete(T object){
        try{
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().delete(object);
            HibernateUtil.commitTransaction();
        }catch (HibernateException e){
            HibernateUtil.rollbackTransaction();
            return false;
        }
        return true;
    }

    public <T> List getAllObjects(T object)
    {
        HibernateUtil.beginTransaction();
        Criteria criteria = HibernateUtil.getSession().createCriteria(object.getClass());
        List<T> list = criteria.list();
        HibernateUtil.commitTransaction();
        return list;
    }

    public <T> List getObjectsBySpecialColumn(T object,String column,Object value){
        HibernateUtil.beginTransaction();
        Criteria criteria = HibernateUtil.getSession().createCriteria(object.getClass());
        criteria.add(Restrictions.eq(column,value));
        List<T> list=criteria.list();
        HibernateUtil.commitTransaction();
        return list;
    }

    public <T> List getObjectsBySpecialColumn(T object,String firstColumn,Object firstValue,String secondColumn,Object secondValue){
        HibernateUtil.beginTransaction();
        Criteria criteria = HibernateUtil.getSession().createCriteria(object.getClass());
        criteria.add(Restrictions.eq(firstColumn,firstValue));
        criteria.add(Restrictions.eq(secondColumn,secondValue));
        List<T> list=criteria.list();
        HibernateUtil.commitTransaction();
        return list;
    }

}
