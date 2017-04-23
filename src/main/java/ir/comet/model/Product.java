package ir.comet.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mohammad on 2/27/2017.
 */

@Entity
@Table
public class Product implements Serializable {

    private long productId;
    private String name;
    private String englishName;
    private String warranty;
    private double price;
    private String imageUrl;
    private String description;
    private long stock;
    private long wareHouseId;
    private int score;
    private double discount;
    private String imageLocationJson;
    private String otherDetailsJson;
    private long branchDetailsId;
    private String colorJson;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    @Column
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column
    public long getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(long wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    @Column
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Column
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Column
    @Type(type = "text")
    public String getImageLocationJson() {
        return imageLocationJson;
    }

    public void setImageLocationJson(String imageLocationJson) {
        this.imageLocationJson = imageLocationJson;
    }

    @Column
    @Type(type = "text")
    public String getOtherDetailsJson() {
        return otherDetailsJson;
    }

    public void setOtherDetailsJson(String otherDetailsJson) {
        this.otherDetailsJson = otherDetailsJson;
    }

    @Column
    public long getBranchDetailsId() {
        return branchDetailsId;
    }

    public void setBranchDetailsId(long branchDetailsId) {
        this.branchDetailsId = branchDetailsId;
    }

    @Column
    @Type(type = "text")
    public String getColorJson() {
        return colorJson;
    }

    public void setColorJson(String colorJson) {
        this.colorJson = colorJson;
    }
}
