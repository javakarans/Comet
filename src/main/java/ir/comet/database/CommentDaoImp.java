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

    private SqlHandler sqlHandler;

    public CommentDaoImp(){
        sqlHandler=SqlHandler.getInstance();
    }

    public void createComment(Comment comment) {
        sqlHandler.create(comment);
    }

    public Comment getComment(long commentId) {
        return (Comment) sqlHandler.getObjectsBySpecialColumn(new Comment(),"commentId",commentId).get(0);
    }

    public List<Comment> getAllCommentsByProductId(long productId) {
        return sqlHandler.getObjectsBySpecialColumn(new Comment(),"productId",productId);
    }

    public void updateComment(Comment comment) {
        sqlHandler.update(comment);
    }

    public void deleteComment(Comment comment) {
        sqlHandler.delete(comment);
    }
}
