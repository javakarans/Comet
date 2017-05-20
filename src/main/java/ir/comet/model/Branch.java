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
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String branchName;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "branch")
    @Fetch(FetchMode.SUBSELECT)
    private List<BranchBrand> branchBrands=new ArrayList<>();

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BranchBrand> getBranchBrands() {
        return branchBrands;
    }

    public void setBranchBrands(List<BranchBrand> branchBrands) {
        this.branchBrands = branchBrands;
    }


}
