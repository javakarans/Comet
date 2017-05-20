package ir.comet.bean;

import ir.comet.database.CommentDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.Comment;
import ir.comet.model.Product;
import ir.comet.model.ProductOrderDetail;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Mohammad on 4/23/2017.
 */
@ManagedBean
@ViewScoped
public class ProductContentBean {

    private Product product;
    private String categoryName;
    private String branchName;
    private String brandName;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private CommentDaoImp commentDaoImp;
    private long productId;

    @PostConstruct
    public void init(){
        commentDaoImp=new CommentDaoImp();
        loadProduct();
    }

    public long getProductId(){
        String productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");
        if(productId!=null){
            this.productId= Long.parseLong(productId);
            return this.productId;
        }
        return userSessionBean.getURLParameter().get("productId");
    }

    public void loadProduct(){
        ProductDaoImp productDaoImp=new ProductDaoImp();
        product=productDaoImp.getProduct(getProductId());
        categoryName=product.getBranchBrand().getBranch().getCategory().getName();
        branchName=product.getBranchBrand().getBranch().getBranchName();
        brandName=product.getBranchBrand().getBrand().getName();
    }

    public long calProductPriceByDiscount(long productPrice,long discount){
        return (productPrice-discount);
    }

    public String addProductToCart(){
        ProductOrderDetail productOrderDetail=new ProductOrderDetail();
        ProductDaoImp productDaoImp=new ProductDaoImp();
        productOrderDetail.setProduct(productDaoImp.getProduct(getProductId()));
        productOrderDetail.setQuantity(1);
        userSessionBean.getProductOrderDetailList().add(productOrderDetail);
        userSessionBean.setCurrentURL("/user/cart.xhtml");
        return userSessionBean.getCurrentURL().concat("?faces-redirect=true");
    }

    public void increaseLike(long commentId){
        Comment comment = commentDaoImp.getComment(commentId);
        int likeCount = comment.getLikeCount()+1;
        comment.setLikeCount(likeCount);
        commentDaoImp.updateComment(comment);
        reloadProductList();
    }

    public void increaseDisLike(long commentId){
        Comment comment = commentDaoImp.getComment(commentId);
        int disLikeCount = comment.getDisLikeCount()+1;
        comment.setDisLikeCount(disLikeCount);
        commentDaoImp.updateComment(comment);
        reloadProductList();
    }

    public void reloadProductList(){
        ProductDaoImp productDaoImp=new ProductDaoImp();
        product=productDaoImp.getProduct(this.productId);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}

