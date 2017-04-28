import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.comet.database.*;
import ir.comet.model.*;
import ir.comet.wrapper.BranchDetailsWrapper;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by amir on 2/24/2017.
 */
public class Test {

    final static Logger logger=Logger.getLogger(Test.class);



    public static void main(String[] args) {

        while (true){
            try{
                HibernateUtil.getSession();
                HibernateUtil.beginTransaction();
                Criteria criteria = HibernateUtil.getSession().createCriteria(Customer.class);
                Customer customer=new Customer();
                customer.setCustomerId(1);
                criteria.add(Restrictions.eq("customerId",customer.getCustomerId()));
                criteria.list().get(0);
                HibernateUtil.commitTransaction();
            }catch (NonUniqueResultException ex){
                System.out.println("Query returned more than one results.");
            }

        }

    }

}
