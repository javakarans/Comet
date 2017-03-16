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
public class WareHouse implements Serializable {

    private long wareHouseId;
    private String name;
    private String address;
    private String wareHouseKeeper;
    private String phoneNumber;
    private long productStock;
    private String postalCode;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(long wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public String getWareHouseKeeper() {
        return wareHouseKeeper;
    }

    public void setWareHouseKeeper(String wareHouseKeeper) {
        this.wareHouseKeeper = wareHouseKeeper;
    }

    @Column
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column
    public long getProductStock() {
        return productStock;
    }

    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }

    @Column
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
