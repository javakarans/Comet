package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Comment;
import ir.comet.model.WareHouse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class WareHouseDaoImp implements WareHouseDao {

    private SessionFactory sessionFactory;

    public WareHouseDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createWareHouse(WareHouse wareHouse) {
        SqlHandler.create(wareHouse);
    }

    public WareHouse getWareHouse(long wareHouseId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WareHouse.class);
        criteria.add(Restrictions.eq("wareHouseId",wareHouseId));
        session.getTransaction().commit();
        session.close();
        List<WareHouse> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public void updateWareHouse(WareHouse wareHouse) {
        SqlHandler.update(wareHouse);
    }

    public void deleteWareHouse(WareHouse wareHouse) {
        SqlHandler.delete(wareHouse);
    }
}
