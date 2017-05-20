package ir.comet.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BranchBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchBrandId;
    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "branchBrand")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products=new ArrayList<>();

    public long getBranchBrandId() {
        return branchBrandId;
    }

    public void setBranchBrandId(long branchBrandId) {
        this.branchBrandId = branchBrandId;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
