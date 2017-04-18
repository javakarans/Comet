package ir.comet.database;

import ir.comet.model.Branch;
import ir.comet.model.Comment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CommentDaoImp implements CommentDao {

    private SessionFactory sessionFactory;

    public CommentDaoImp(){
        sessionFactory = HibernateSession.getInstance().getSession().getSessionFactory();
    }

    public void createComment(Comment comment) {
        SqlHandler.create(comment);
    }

    public Comment getComment(long commentId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Comment.class);
        criteria.add(Restrictions.eq("commentId",commentId));
        session.getTransaction().commit();
        session.close();
        List<Comment> list = criteria.list();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public List<Comment> getAllComments(long commentId) {
        return null;
    }

    public void updateComment(Comment comment) {
        SqlHandler.update(comment);
    }

    public void deleteComment(Comment comment) {
        SqlHandler.delete(comment);
    }
}
