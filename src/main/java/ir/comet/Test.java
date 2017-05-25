package ir.comet;

import ir.comet.Utilities.TrackNumber;
import ir.comet.database.BranchDao;
import ir.comet.database.BranchDaoImp;
import ir.comet.database.CustomerDaoImp;
import ir.comet.database.HibernateUtil;
import ir.comet.model.Branch;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mohammad on 5/20/2017.
 */
public class Test {

    public static void main(String[] args) {

        HibernateUtil.beginTransaction();
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Product.class);
        long id= (long) criteria.setProjection(Projections.max("price")).uniqueResult();
        System.out.println(id);
//        List<Product> list = criteria.list();
//        Iterator<Product> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().getProductId());
//        }
    }

}
