package ir.comet.bean;

import ir.comet.controller.CommentController;
import ir.comet.controller.ProductController;
import ir.comet.database.BranchDetailsDaoImp;
import ir.comet.database.CommentDao;
import ir.comet.database.CommentDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.BranchDetails;
import ir.comet.model.Comment;
import ir.comet.model.Product;
import ir.comet.wrapper.BranchDetailsWrapper;
import ir.comet.wrapper.UserProductCart;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private BranchDetailsWrapper branchDetailsWrapper;
    private Product product;
    private CommentController commentController;
    private ProductController productController;

    @PostConstruct
    public void init(){
        branchDetailsWrapper=userSessionBean.getBranchDetailsWrapper();
        product=userSessionBean.getSelectedProduct();
        productController=new ProductController();
        commentController=new CommentController();
    }

    public List<Comment> loadComments(){
        CommentDaoImp commentDaoImp=new CommentDaoImp();
        return commentDaoImp.getAllCommentsByProductId(product.getProductId());
    }

    public String addProductToCart(Product product){
        userSessionBean.getUserProductCartList().add(new UserProductCart(product));
        return "/user/cart.xhtml?faces-redirect=true";
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

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
