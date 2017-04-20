package ir.comet.model;


import javax.persistence.*;

@Entity
@Table
public class BranchDetails {

    private long branchDetailsId ;
    private long brandId;
    private long branchId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public long getBranchDetailsId() {
        return branchDetailsId;
    }

    public void setBranchDetailsId(long branchDetailsId) {
        this.branchDetailsId = branchDetailsId;
    }

    @Column
    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    @Column
    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }
}
