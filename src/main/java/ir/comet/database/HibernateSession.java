package ir.comet.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class HibernateSession {

    private static HibernateSession hibernateSession;

    protected HibernateSession() {

    }

    /**
     * This method get an instance from HibernateSession Class
     * to implement sigleton design pattern
     * @return hibernateSession
     */
    public static HibernateSession getInstance() {
        if (hibernateSession == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (HibernateSession.class) {
                if (hibernateSession == null) {
                    hibernateSession = new HibernateSession();
                }
            }
        }
        return hibernateSession;

    }

    /**
     * This method creates a session factory to connect to DB
     * @return session
     */
    public SessionFactory getSession(){
        Configuration configuration=new Configuration().configure();
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}