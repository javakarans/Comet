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
    private SessionFactory sessionFactory;

    private HibernateSession() {
        Configuration configuration=new Configuration().configure();
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory=configuration.buildSessionFactory(builder.build());
    }

    public static HibernateSession getInstance() {
            synchronized (HibernateSession.class) {
                if (hibernateSession == null) {
                    hibernateSession = new HibernateSession();
                }
            }
        return hibernateSession;
    }

    public static Session getSession(){
        Session session = HibernateSession.getInstance().sessionFactory.openSession();
        return session;
    }

}