package ir.comet.bean;

import ir.comet.Utilities.SolarCalendar;
import ir.comet.database.CommentDaoImp;
import ir.comet.database.CustomerDaoImp;
import ir.comet.database.ProductDaoImp;
import ir.comet.model.Comment;
import ir.comet.model.Customer;
import ir.comet.model.Product;
import ir.comet.model.ProductOrderDetail;
import org.jsoup.Jsoup;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Collections;

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
    private String commentText;
    private String color;

    @PostConstruct
    public void init(){
        commentDaoImp=new CommentDaoImp();
        loadProduct();
    }

    public long getProductId(){
        String productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");
            this.productId= Long.parseLong(productId);
            return this.productId;
    }

    public void loadProduct(){
        ProductDaoImp productDaoImp=new ProductDaoImp();
        product=productDaoImp.getProduct(getProductId());
        Collections.reverse(product.getComments());
        categoryName=product.getBranchBrand().getBranch().getCategory().getName();
        branchName=product.getBranchBrand().getBranch().getBranchName();
        brandName=product.getBranchBrand().getBrand().getName();
    }

    public String[] loadProductColors(){
        String colors = product.getColorJson();
        return colors.split(",");
    }

    public long calProductPriceByDiscount(long productPrice,long discount){
        return (productPrice-discount);
    }

    public String addProductToCart(){
        ProductOrderDetail productOrderDetail=new ProductOrderDetail();
        ProductDaoImp productDaoImp=new ProductDaoImp();
        productOrderDetail.setProduct(productDaoImp.getProduct(productId));
        productOrderDetail.setQuantity(1);
        productOrderDetail.setColor(color);
        boolean addProduct=true;
        if(!userSessionBean.getProductOrderDetailList().isEmpty()){
            for (ProductOrderDetail detail:userSessionBean.getProductOrderDetailList()
                 ) {
                if(detail.getProduct().getProductId()==productOrderDetail.getProduct().getProductId()){
                    if(detail.getColor().equals(productOrderDetail.getColor())){
                        detail.setQuantity(detail.getQuantity()+1);
                        addProduct=false;
                        break;
                    }
                }
            }
            if(addProduct){
                userSessionBean.getProductOrderDetailList().add(productOrderDetail);
            }
        }
        else{
            userSessionBean.getProductOrderDetailList().add(productOrderDetail);
        }

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

    public void createComment(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        Customer customer = customerDaoImp.getCustomer(userSessionBean.getUserSessionId());
        Comment comment=new Comment();
        comment.setCustomer(customer);
        comment.setProduct(product);
        comment.setText(commentText);
        SolarCalendar solarCalendar=new SolarCalendar();
        String date=solarCalendar.getDate()+" "+solarCalendar.strMonth+" "+solarCalendar.getYear();
        comment.setCreatedDate(date);
        comment.setLikeCount(0);
        comment.setDisLikeCount(0);
        commentDaoImp.createComment(comment);
        refreshComments();
    }

    public String showCommentText(String text){
        return Jsoup.parse(text).text();
    }

    public void reloadProductList(){
        ProductDaoImp productDaoImp=new ProductDaoImp();
        product=productDaoImp.getProduct(this.productId);
    }

    private void refreshComments(){
        commentText="";
        loadProduct();
    }

    public String showProductContent(){
        return Jsoup.parse(product.getDescription()).text();
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

