package ir.comet.database;

import ir.comet.model.Category;
import ir.comet.model.Comment;

import java.util.List;

/**
 * Created by Mohammad on 2/28/2017.
 */
public interface CommentDao {

    public void createComment(Comment comment);
    public Comment getComment(long commentId);
    public List<Comment> getAllComments(long commentId);
    public void updateComment(Comment comment);
    public void deleteComment(Comment comment);
}
