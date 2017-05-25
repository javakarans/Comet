package ir.comet.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class TechnicalSpecification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long technicalSpecificationId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "TechnicalSpecification")
    @Fetch(FetchMode.SUBSELECT)
    private List<TechnicalSpecificationDetails> technicalSpecificationDetailss = new ArrayList<>();



    public long getTechnicalSpecificationId() {
        return technicalSpecificationId;
    }

    public void setTechnicalSpecificationId(long technicalSpecificationId) {
        this.technicalSpecificationId = technicalSpecificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<TechnicalSpecificationDetails> getTechnicalSpecificationDetailss() {
        return technicalSpecificationDetailss;
    }

    public void setTechnicalSpecificationDetailss(List<TechnicalSpecificationDetails> technicalSpecificationDetailss) {
        this.technicalSpecificationDetailss = technicalSpecificationDetailss;
    }
}
