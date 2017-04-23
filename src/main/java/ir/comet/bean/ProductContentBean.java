package ir.comet.bean;

import ir.comet.controller.CommentController;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.CommentDao;
import ir.comet.database.CommentDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Comment;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mohammad on 4/23/2017.
 */
@ManagedBean
@ViewScoped
public class ProductContentBean {

    private HashMap<String, Long> urlParams;
    private BranchDetailsWrapper branchDetailsWrapper;
    private Product product;
    private CommentController commentController;

    @PostConstruct
    public void init(){
        urlParams = getParametersFromUrl();
        loadProduct();
        loadComments();
        commentController=new CommentController();
    }

    public HashMap<String,Long> getParametersFromUrl(){
        long productId = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId"));
        HashMap<String,Long> hashMap=new HashMap<String, Long>();
        hashMap.put("productId",productId);
        return hashMap;
    }

    public void loadBranchDetailsWrapper(){

    }

    public void loadProduct(){
        ProductDaoImp productDaoImp=new ProductDaoImp();
        product = productDaoImp.getProduct(urlParams.get("productId"));

    }

    public List<Comment> loadComments(){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        return commentDaoImp.getAllCommentsByProductId(urlParams.get("productId"));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CommentController getCommentController() {
        return commentController;
    }

    public void setCommentController(CommentController commentController) {
        this.commentController = commentController;
    }
}
