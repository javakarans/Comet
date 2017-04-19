package ir.comet.model;

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
    private String color;
    private String warranty;
    private double price;
    private String imageUrl;
    private String description;
    private long branchId;
    private long stock;
    private long wareHouseId;
    private float score;
    private String json;
    private String categoryName;
    private String brandName;
    private String discount;
   // private String[] fileAddress;
    private String imageLocation1;
    private String imageLocation2;
    private String imageLocation3;
    private String imageLocation4;

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
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Column
    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    @Column
    public long getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(long wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    @Column
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Column
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column
    public String getBrandName() {
        return brandName;
    }

    @Column
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

   /* @Column
    @OneToMany
    public String[] getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String[] fileAddress) {
        this.fileAddress = fileAddress;
    }*/

   @Column
    public String getImageLocation1() {
        return imageLocation1;
    }

    public void setImageLocation1(String imageLocation1) {
        this.imageLocation1 = imageLocation1;
    }

    @Column
    public String getImageLocation2() {
        return imageLocation2;
    }

    public void setImageLocation2(String imageLocation2) {
        this.imageLocation2 = imageLocation2;
    }

    @Column
    public String getImageLocation3() {
        return imageLocation3;
    }

    public void setImageLocation3(String imageLocation3) {
        this.imageLocation3 = imageLocation3;
    }

    @Column
    public String getImageLocation4() {
        return imageLocation4;
    }

    public void setImageLocation4(String imageLocation4) {
        this.imageLocation4 = imageLocation4;
    }
}
