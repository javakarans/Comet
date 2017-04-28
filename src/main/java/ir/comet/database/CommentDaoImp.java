package ir.comet.database;

import ir.comet.model.Comment;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public class CommentDaoImp implements CommentDao {

    private SQLService SQLService;

    public CommentDaoImp(){
        SQLService =new SQLService();
    }

    public void createComment(Comment comment) {
        SQLService.create(comment);
    }

    public Comment getComment(long commentId) {
        return (Comment) SQLService.getObjectsBySpecialColumn(new Comment(),"commentId",commentId).get(0);
    }

    public List<Comment> getAllCommentsByProductId(long productId) {
        return SQLService.getObjectsBySpecialColumn(new Comment(),"productId",productId);
    }

    public void updateComment(Comment comment) {
        SQLService.update(comment);
    }

    public void deleteComment(Comment comment) {
        SQLService.delete(comment);
    }
}
