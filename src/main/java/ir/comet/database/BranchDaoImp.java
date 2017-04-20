package ir.comet.database;

import ir.comet.model.Branch;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class BranchDaoImp implements BranchDao{

    private SessionFactory sessionFactory;

    public BranchDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createBranch(Branch branch) {
        SqlHandler.create(branch);
    }

    public Branch getBranch(long branchId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Branch.class);
        criteria.add(Restrictions.eq("branchId",branchId));
        session.getTransaction().commit();
        session.close();
        List<Branch> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Branch> getAllBranches() {

        Branch branch = new Branch();
        return SqlHandler.getAllObjects(branch);
    }

    public void updateBranch(Branch branch) {
        SqlHandler.update(branch);
    }

    public void deleteBranch(Branch branch) {
        SqlHandler.delete(branch);
    }
}
