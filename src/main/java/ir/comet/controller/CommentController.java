package ir.comet.controller;

import ir.comet.database.CommentDaoImp;
import ir.comet.model.Comment;

/**
 * Created by Mohammad on 4/23/2017.
 */
public class CommentController {

    public void increaseLike(long commentId){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        Comment comment = commentDaoImp.getComment(commentId);
        int likeCount = comment.getLikeCount()+1;
        comment.setLikeCount(likeCount);
        commentDaoImp.updateComment(comment);
    }

    public void increaseDisLike(long commentId){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        Comment comment = commentDaoImp.getComment(commentId);
        int disLikeCount = comment.getDisLikeCount()+1;
        comment.setDisLikeCount(disLikeCount);
        commentDaoImp.updateComment(comment);
    }

}
