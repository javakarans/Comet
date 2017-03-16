package ir.comet.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        session.close();
    }

    public static <T> void update(T object){
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public static <T> void delete(T object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

}
