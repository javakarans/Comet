package ir.comet.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammad on 2/27/2017.
 */

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;
    private String englishName;
    private String warranty;
    private long price;
    @Type(type = "text")
    private String imageUrl;
    @Type(type = "text")
    private String description;
    private long stock;
    private long wareHouseId;
    private int score;
    private long discount;
    @Type(type = "text")
    private String imageLocationJson;
    @Type(type = "text")
    private String otherDetailsJson;
    @Type(type = "text")
    private String colorJson;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "product")
    @Fetch(FetchMode.SUBSELECT)
    private List<Comment> comments=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "product")
    @Fetch(FetchMode.SUBSELECT)
    private List<ProductOrderDetail> productOrderDetails=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "branchBrandId")
    private BranchBrand branchBrand;
    private long soldCount;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(long wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public String getImageLocationJson() {
        return imageLocationJson;
    }

    public void setImageLocationJson(String imageLocationJson) {
        this.imageLocationJson = imageLocationJson;
    }

    public String getOtherDetailsJson() {
        return otherDetailsJson;
    }

    public void setOtherDetailsJson(String otherDetailsJson) {
        this.otherDetailsJson = otherDetailsJson;
    }

    public String getColorJson() {
        return colorJson;
    }

    public void setColorJson(String colorJson) {
        this.colorJson = colorJson;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(List<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }

    public BranchBrand getBranchBrand() {
        return branchBrand;
    }

    public void setBranchBrand(BranchBrand branchBrand) {
        this.branchBrand = branchBrand;
    }

    public long getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(long soldCount) {
        this.soldCount = soldCount;
    }
}
