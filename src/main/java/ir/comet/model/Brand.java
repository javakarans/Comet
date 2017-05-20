package ir.comet.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long brandId;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "brand")
    @Fetch(FetchMode.SUBSELECT)
    private List<BranchBrand> branchBrands=new ArrayList<>();

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BranchBrand> getBranchBrands() {
        return branchBrands;
    }

    public void setBranchBrands(List<BranchBrand> branchBrands) {
        this.branchBrands = branchBrands;
    }
}
